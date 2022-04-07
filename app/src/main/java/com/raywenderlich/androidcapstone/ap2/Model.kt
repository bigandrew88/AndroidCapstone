package com.raywenderlich.androidcapstone.ap2

class Model {
    data class Customer (
        val firstName: String,
        val lastName: String,
        val email: String,
        val dateOfBirth: String,
        val homes: List<Home>,
        val autos: List<Auto>,
        val id: Long
    )

    data class Auto (
        val autoID: Long,
        val make: String,
        val model: String,
        val dateMade: String,
        val autoQuotes: List<AutoQuote>,
        val autoPolicy: AutoPolicy
    )

    data class AutoPolicy (
        val autoPolicyID: Long,
        val autoPolicyPremium: Double,
        val autoPolicyStartDate: String,
        val autoPolicyEndDate: String
    )

    data class AutoQuote (
        val autoQuoteID: Long,
        val autoQuotePremium: Double,
        val autoQuoteStartDate: String,
        val autoQuoteEndDate: String
    )

    data class Home (
        val homeID: Long,
        val heatingType: String,
        val location: String,
        val value: Long,
        val streetNumber: Long,
        val streetName: String,
        val city: String,
        val postalcode: String,
        val dateBuilt: String,
        val homeQuotes: List<HomeQuote>,
        val homePolicy: HomePolicy
    )

    data class HomePolicy (
        val homePolicyID: Long,
        val homePolicyPremium: Double,
        val homePolicyStartDate: String,
        val homePolicyEndDate: String
    )

    data class HomeQuote (
        val homeQuoteID: Long,
        val homeQuotePremium: Double,
        val homeQuoteStartDate: String,
        val homeQuoteEndDate: String
    )
}