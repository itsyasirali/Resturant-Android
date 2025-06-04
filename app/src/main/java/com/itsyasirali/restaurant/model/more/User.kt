package com.itsyasirali.restaurant.model.more

data class User(
    var uid: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val address: String = "",
    val password: String = ""
)
