package com.example.readingjson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(val title: String, @SerialName("short_dec") val shortDec: String, val content: String, @SerialName("img_url") val imgUrl: String, val type: String)
