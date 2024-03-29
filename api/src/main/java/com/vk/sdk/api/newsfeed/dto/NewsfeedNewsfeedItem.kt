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
package com.vk.sdk.api.newsfeed.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.aliexpress.dto.AliexpressBlockPanel
import com.vk.sdk.api.aliexpress.dto.AliexpressCarouselItem
import com.vk.sdk.api.apps.dto.AppsApp
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCommentsInfo
import com.vk.sdk.api.base.dto.BaseGeo
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.base.dto.BaseLinkButton
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaCarouselBlockGroup
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaItemExtended
import com.vk.sdk.api.discover.dto.DiscoverCarouselButton
import com.vk.sdk.api.discover.dto.DiscoverCarouselItem
import com.vk.sdk.api.discover.dto.DiscoverCarouselObjectsType
import com.vk.sdk.api.groups.dto.GroupsSuggestion
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItem
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItemEndCard
import com.vk.sdk.api.stories.dto.StoriesStory
import com.vk.sdk.api.textlives.dto.TextlivesTextliveTextpostBlock
import com.vk.sdk.api.video.dto.VideoVideo
import com.vk.sdk.api.wall.dto.WallPostSource
import com.vk.sdk.api.wall.dto.WallViews
import com.vk.sdk.api.wall.dto.WallWallpost
import com.vk.sdk.api.wall.dto.WallWallpostAttachment
import java.lang.IllegalStateException
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

sealed class NewsfeedNewsfeedItem {
    /**
     * @param activity
     * @param attachments
     * @param comments
     * @param copyHistory
     * @param feedback
     * @param geo
     * @param isFavorite - Information whether the post in favorites list
     * @param likes
     * @param markedAsAds - Information whether the post is marked as ads
     * @param postId - Post ID
     * @param postSource
     * @param postType
     * @param reposts
     * @param signerId - Post signer ID
     * @param text - Post text
     * @param views - Count of views
     * @param shortTextRate - Preview length control parameter
     * @param carouselOffset - Index of current carousel element
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemWallpost(
        @SerializedName("activity")
        val activity: NewsfeedEventActivity? = null,
        @SerializedName("attachments")
        val attachments: List<WallWallpostAttachment>? = null,
        @SerializedName("comments")
        val comments: BaseCommentsInfo? = null,
        @SerializedName("copy_history")
        val copyHistory: List<WallWallpost>? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedback? = null,
        @SerializedName("geo")
        val geo: BaseGeo? = null,
        @SerializedName("is_favorite")
        val isFavorite: Boolean? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfo? = null,
        @SerializedName("marked_as_ads")
        val markedAsAds: BaseBoolInt? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("post_source")
        val postSource: WallPostSource? = null,
        @SerializedName("post_type")
        val postType: NewsfeedItemWallpostType? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfo? = null,
        @SerializedName("signer_id")
        val signerId: Int? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("views")
        val views: WallViews? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param photos
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemPhoto(
        @SerializedName("photos")
        val photos: NewsfeedItemPhotoPhotos? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param photoTags
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemPhotoTag(
        @SerializedName("photo_tags")
        val photoTags: NewsfeedItemPhotoTagPhotoTags? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param friends
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemFriend(
        @SerializedName("friends")
        val friends: NewsfeedItemFriendFriends? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param audio
     * @param postId - Post ID
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemAudio(
        @SerializedName("audio")
        val audio: NewsfeedItemAudioAudio? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param video
     * @param carouselOffset - Index of current carousel element
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemVideo(
        @SerializedName("video")
        val video: NewsfeedItemVideoVideo? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param comments
     * @param likes
     * @param postId - Topic post ID
     * @param text - Post text
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemTopic(
        @SerializedName("comments")
        val comments: BaseCommentsInfo? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfo? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param feedId - id of feed in digest
     * @param items
     * @param mainPostIds
     * @param template - type of digest
     * @param header
     * @param footer
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemDigest(
        @SerializedName("feed_id")
        val feedId: String? = null,
        @SerializedName("items")
        val items: List<NewsfeedItemDigestItem>? = null,
        @SerializedName("main_post_ids")
        val mainPostIds: List<String>? = null,
        @SerializedName("template")
        val template: NewsfeedItemDigest.Template? = null,
        @SerializedName("header")
        val header: NewsfeedItemDigestHeader? = null,
        @SerializedName("footer")
        val footer: NewsfeedItemDigestFooter? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Template(
            val value: String
        ) {
            @SerializedName("list")
            LIST("list"),

            @SerializedName("grid")
            GRID("grid"),

            @SerializedName("single")
            SINGLE("single");
        }
    }

    /**
     * @param text
     * @param title
     * @param action
     * @param images
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemPromoButton(
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("action")
        val action: NewsfeedItemPromoButtonAction? = null,
        @SerializedName("images")
        val images: List<NewsfeedItemPromoButtonImage>? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param blockType
     * @param stories
     * @param title
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemStoriesBlock(
        @SerializedName("block_type")
        val blockType: NewsfeedItemStoriesBlock.BlockType? = null,
        @SerializedName("stories")
        val stories: List<StoriesStory>? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem() {
        enum class BlockType(
            val value: String
        ) {
            @SerializedName("local")
            LOCAL("local"),

            @SerializedName("remote")
            REMOTE("remote");
        }
    }

    /**
     * @param banner
     * @param poll
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemFeedbackPoll(
        @SerializedName("banner")
        val banner: NewsfeedItemFeedbackPollBanner? = null,
        @SerializedName("poll")
        val poll: NewsfeedItemFeedbackPollPoll? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param blockId
     * @param text
     * @param animation
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemAnimatedBlock(
        @SerializedName("block_id")
        val blockId: String? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("animation")
        val animation: NewsfeedItemAnimatedBlockAnimation? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param title
     * @param trackCode
     * @param items
     * @param nextFrom - Next from value
     * @param button
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemClipsBlock(
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("items")
        val items: List<VideoVideo>? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("button")
        val button: BaseLinkButton? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param title - Title of the block
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param trackCode - Track code of the block
     * @param button
     * @param type
     * @param nextFrom - Encoded string for the next page
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemRecommendedGroupsBlock(
        @SerializedName("title")
        val title: String,
        @SerializedName("items")
        val items: List<GroupsSuggestion>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("button")
        val button: BaseLinkButton,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param endCard
     * @param recognitionArticleLink - help link
     * @param trackCode - Track code of the block
     * @param items
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemRecognizeBlock(
        @SerializedName("end_card")
        val endCard: PhotosTagsSuggestionItemEndCard? = null,
        @SerializedName("recognition_article_link")
        val recognitionArticleLink: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("items")
        val items: List<PhotosTagsSuggestionItem>? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param button
     * @param items
     * @param objects
     * @param objectsType
     * @param title
     * @param trackCode
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemGamesCarousel(
        @SerializedName("button")
        val button: DiscoverCarouselButton? = null,
        @SerializedName("items")
        val items: List<DiscoverCarouselItem>? = null,
        @SerializedName("objects")
        val objects: List<AppsApp>? = null,
        @SerializedName("objects_type")
        val objectsType: DiscoverCarouselObjectsType? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param textliveTextpostBlock
     * @param trackCode
     * @param keepOffline
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemTextliveBlock(
        @SerializedName("textlive_textpost_block")
        val textliveTextpostBlock: TextlivesTextliveTextpostBlock? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("keep_offline")
        val keepOffline: Boolean? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type - type
     * @param items
     * @param createButtonUrl - Create button url
     * @param moreButtonUrl - More button url
     * @param blockTitle - Block title
     * @param blockDescription - Block description
     * @param trackCode
     * @param group
     */
    data class NewsfeedItemYoulaCarouselBlock(
        @SerializedName("type")
        val type: NewsfeedItemYoulaCarouselBlock.Type,
        @SerializedName("items")
        val items: List<ClassifiedsYoulaItemExtended>,
        @SerializedName("create_button_url")
        val createButtonUrl: String,
        @SerializedName("more_button_url")
        val moreButtonUrl: String,
        @SerializedName("block_title")
        val blockTitle: String? = null,
        @SerializedName("block_description")
        val blockDescription: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("group")
        val group: ClassifiedsYoulaCarouselBlockGroup? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("youla_carousel")
            YOULA_CAROUSEL("youla_carousel");
        }
    }

    /**
     * @param type - type
     * @param blockTitle - Block title
     * @param items
     * @param moreButton - More button url
     * @param trackCode
     * @param blockPanel - Block top panel
     */
    data class NewsfeedItemAliexpressCarouselBlock(
        @SerializedName("type")
        val type: NewsfeedItemAliexpressCarouselBlock.Type,
        @SerializedName("block_title")
        val blockTitle: String,
        @SerializedName("items")
        val items: List<AliexpressCarouselItem>,
        @SerializedName("more_button")
        val moreButton: BaseLinkButton,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("block_panel")
        val blockPanel: AliexpressBlockPanel? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("aliexpress_carousel")
            ALIEXPRESS_CAROUSEL("aliexpress_carousel");
        }
    }

    /**
     * @param app
     * @param title
     * @param buttonText
     * @param trackCode
     * @param friendsPlayingText
     * @param friendsAvatars
     * @param appCover
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     */
    data class NewsfeedItemRecommendedGameBlock(
        @SerializedName("app")
        val app: AppsApp,
        @SerializedName("title")
        val title: String,
        @SerializedName("button_text")
        val buttonText: String,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("friends_playing_text")
        val friendsPlayingText: String? = null,
        @SerializedName("friends_avatars")
        val friendsAvatars: List<List<BaseImage>>? = null,
        @SerializedName("app_cover")
        val appCover: List<BaseImage>? = null,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType? = null,
        @SerializedName("source_id")
        val sourceId: Int? = null,
        @SerializedName("date")
        val date: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param expertCard
     */
    data class NewsfeedItemExpertCardWidget(
        @SerializedName("type")
        val type: NewsfeedItemExpertCardWidget.Type? = null,
        @SerializedName("expert_card")
        val expertCard: NewsfeedExpertCardWidget? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("expert_card")
            EXPERT_CARD("expert_card");
        }
    }

    class Deserializer : JsonDeserializer<NewsfeedNewsfeedItem> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): NewsfeedNewsfeedItem {
            val type = json.asJsonObject.get("type").asString
            return when(type) {
                "post" -> context.deserialize(json, NewsfeedItemWallpost::class.java)
                "photo" -> context.deserialize(json, NewsfeedItemPhoto::class.java)
                "wall_photo" -> context.deserialize(json, NewsfeedItemPhoto::class.java)
                "photo_tag" -> context.deserialize(json, NewsfeedItemPhotoTag::class.java)
                "friend" -> context.deserialize(json, NewsfeedItemFriend::class.java)
                "audio" -> context.deserialize(json, NewsfeedItemAudio::class.java)
                "video" -> context.deserialize(json, NewsfeedItemVideo::class.java)
                "topic" -> context.deserialize(json, NewsfeedItemTopic::class.java)
                "digest" -> context.deserialize(json, NewsfeedItemDigest::class.java)
                "promo_button" -> context.deserialize(json, NewsfeedItemPromoButton::class.java)
                else -> throw IllegalStateException("no mapping for the type:" + type)
            }
        }
    }
}
