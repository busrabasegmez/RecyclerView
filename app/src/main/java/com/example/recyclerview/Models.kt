package com.example.recyclerview

import com.google.gson.annotations.SerializedName


class HomeFeed(val videos: List<Video>)

class Video(
    val id: Int, val name: String, val link: String, val imageUrl: String,
    val numberOfViews: Int, val channel: Channel
)

class Channel(val name: String, @SerializedName("profileimageUrl") val profileImageUrl: String)

