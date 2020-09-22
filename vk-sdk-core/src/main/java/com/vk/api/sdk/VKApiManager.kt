/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package com.vk.api.sdk

import com.vk.api.sdk.chain.*
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.okhttp.OkHttpExecutor
import com.vk.api.sdk.okhttp.OkHttpExecutorConfig
import com.vk.api.sdk.okhttp.OkHttpMethodCall
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Class for execution api request
 */
@Suppress("UseExpressionBody")
open class VKApiManager(val config: VKApiConfig) {

    private val rateLimitBackoff by lazy {
        RateLimitReachedChainCall.RateLimitBackoff(
            context = config.context,
            backoffTimeMs = config.rateLimitBackoffTimeoutMs
        )
    }

    internal val validationHandler: VKApiValidationHandler? = config.validationHandler

    open val executor by lazy { OkHttpExecutor(OkHttpExecutorConfig(config)) }

    @Volatile
    var illegalCredentialsListener: VKApiIllegalCredentialsListener? = null

    /**
     * Override credentials
     * @param accessToken
     * @param secret
     */
    fun setCredentials(accessToken: String, secret: String?) {
        executor.setCredentials(accessToken, secret)
    }

    /**
     * Ignore all method requests with specific access token. All executions of that requests will
     * throw [com.vk.api.sdk.exceptions.IgnoredAccessTokenException]
     *
     * @param accessToken token to ignore. null to allow all access tokens
     */
    fun ignoreAccessToken(accessToken: String?) {
        executor.ignoreAccessToken(accessToken)
    }

    /**
     * Override credentials
     * @param call
     */
    fun execute(call: VKMethodCall): Unit = execute(call, VKApiResponseParser { Unit })

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun <T> execute(call: VKMethodCall, parser: VKApiResponseParser<T>? = null): T {
        var cc: ChainCall<T> = createMethodChainCall(call, parser)
        cc = wrapCall(call, cc)
        return executeWithExceptionAdjust(cc)
    }

    protected open fun <T> wrapCall(call: VKMethodCall, chainCall: ChainCall<T>): ChainCall<T> {
        var cc: ChainCall<T> = if (call.skipValidation) {
            chainCall
        } else {
            createValidationHandlerChainCall(call.retryCount, chainCall)
        }

        cc = InvalidCredentialsObserverChainCall(this, cc, 1)
        cc = TooManyRequestRetryChainCall(this, call.retryCount, cc)
        cc = RateLimitReachedChainCall(this, call.method, rateLimitBackoff, cc)
        if (call.retryCount > 0) {
            cc = InternalErrorRetryChainCall(this, call.retryCount, cc)
        }
        return cc
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    @JvmOverloads
    fun <T> execute(call: VKHttpPostCall, progress: VKApiProgressListener? = null, parser: VKApiResponseParser<T>? = null): T {
        var cc: ChainCall<T> = HttpPostChainCall(this, executor, call, progress, parser)
        cc = wrapCall(call, cc)
        return executeWithExceptionAdjust(cc)
    }

    protected open fun <T> wrapCall(call: VKHttpPostCall, chainCall: ChainCall<T>): ChainCall<T> {
        var cc: ChainCall<T> = createValidationHandlerChainCall(call.retryCount, chainCall)
        if (call.retryCount > 0) {
            cc = InternalErrorRetryChainCall(this, call.retryCount, cc)
        }
        return cc
    }

    private fun <T> createValidationHandlerChainCall(retryCount: Int, chainCall: ChainCall<T>) =
        ValidationHandlerChainCall(this, retryCount, chainCall)

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    protected open fun <T> executeWithExceptionAdjust(cc: ChainCall<T>) = cc.call(ChainArgs())!!

    protected open fun <T> createMethodChainCall(call: VKMethodCall, parser: VKApiResponseParser<T>? = null): ChainCall<T> =
            MethodChainCall(this, executor, OkHttpMethodCall.Builder().from(call), config.deviceId.value, config.lang, parser)
}
