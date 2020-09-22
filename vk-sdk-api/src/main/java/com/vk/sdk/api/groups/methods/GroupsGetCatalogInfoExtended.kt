/**
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
*/
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api.groups.methods

import com.vk.sdk.api.ApiRequestBase
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.groups.dto.GroupsGetCatalogInfoExtendedResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetCatalogInfoExtendedResponse
import kotlin.Boolean
import org.json.JSONObject

/**
 * Returns categories list for communities catalog
 * @param extended 1 - to return communities count and three communities for preview. By default: 0.
 * default 0
 * @param subcategories 1 - to return subcategories info. By default: 0. default 0
 */
class GroupsGetCatalogInfoExtended(
    private val extended: Boolean? = null,
    private val subcategories: Boolean? = null
) : ApiRequestBase<GroupsGetCatalogInfoExtendedResponseDto>(methodName = "groups.getCatalogInfo") {
    init {
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        subcategories?.let { value ->
            addParam("subcategories", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): GroupsGetCatalogInfoExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            GroupsGetCatalogInfoExtendedResponse::class.java).response
}
