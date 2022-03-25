package com.example.demotcs.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("mobile")
    val mobile: String,
    @SerialName("password")
    val password: String,
    @SerialName("gender")
    val gender: String
){

}