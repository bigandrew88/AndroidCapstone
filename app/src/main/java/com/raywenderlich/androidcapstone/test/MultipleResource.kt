package com.raywenderlich.androidcapstone.test

import com.google.gson.annotations.SerializedName

class MultipleResource {
        @SerializedName("firstName")
        val firstName: String? = null

        @SerializedName("lastName")
        val lastName: String? = null

        @SerializedName("email")
        val email: String? = null

        @SerializedName("dateOfBirth")
        val dateOfBirth: String? = null

        @SerializedName("homes")
        val homes: List<Homes2>? = null

        @SerializedName("autos")
        val autos: List<Autos2>? = null
}