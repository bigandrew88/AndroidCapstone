package com.raywenderlich.androidcapstone.API

class ApiCustomerResponse (
    val firstName: String,
    val lastName: String,
    val email: String,
    val dateOfBirth: String,
    val password: String,
    val homes: List<Home>,
    val autos: List<Auto>
){
    data class Auto (
        val make: String,
        val model: String,
        val dateMade: String,
        val autoQuotes: List<AutoQuote>,
        val autoPolicy: AutoPolicy
    )

    data class AutoPolicy (
        val autoPolicyPremium: Double,
        val autoPolicyStartDate: String,
        val autoPolicyEndDate: String
    )

    data class AutoQuote (
        val autoQuotePremium: Double,
        val autoQuoteStartDate: String,
        val autoQuoteEndDate: String
    )

    data class Home (
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
        val homePolicyPremium: Double,
        val homePolicyStartDate: String,
        val homePolicyEndDate: String
    )

    data class HomeQuote (
        val homeQuotePremium: Double,
        val homeQuoteStartDate: String,
        val homeQuoteEndDate: String
    )
}