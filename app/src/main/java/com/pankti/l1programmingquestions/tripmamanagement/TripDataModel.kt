package com.pankti.l1programmingquestions.tripmamanagement

import java.util.UUID

data class TripDataModel(
    val id: String = UUID.randomUUID().toString(),
    val tripName: String,
    val source: String,
    var destination: String,
    var startDate: String,
    val endDate: String,
    val itinerary : String ,
    var isFavourite: Boolean = false,
    var joiningTripStatus: JoinTripStatus = JoinTripStatus.NONE,
    var allowForTrip: Boolean = false,
)

data class UserDataModel(
    val userId: String = UUID.randomUUID().toString(),
    val name: String, val age: String, val gender: String,
)

enum class JoinTripStatus {
    APPROVED, REJECTED, PENDING, NONE
}
