package com.example.quadriabdulfatai2009003

data class Deliveries(
    val Container: Container,
    val General: General,
    val Vehicles: Vehicles,
    val Voyage: Int,
    val message: String,
    val success: Boolean
)

data class Container(
    val discharged: Int,
    val discharged_list: List<Discharged>,
    val not_discharged: Int,
    val total: Int
)

data class General(
    val discharged: Int,
    val discharged_list: List<DischargedX>,
    val not_discharged: Int,
    val total: Int
)

data class Vehicles(
    val discharged: Int,
    val discharged_list: List<DischargedXX>,
    val not_discharged: Int,
    val total: Int
)

data class Discharged(
    val type: String,
    val value: Int
)

data class DischargedX(
    val type: String,
    val value: Int
)

data class DischargedXX(
    val type: String,
    val value: Int
)