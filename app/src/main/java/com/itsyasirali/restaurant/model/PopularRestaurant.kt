package com.itsyasirali.restaurant.model

data class PopularRestaurant(
    val name: String,
    val rate: Float,
    val rateCount: Int,
    val foodKind: String,
    val coverImage: Int
)
