package com.pankti.l1programmingquestions.tripmamanagement


interface TripRepository {

    fun createTrip(tripData: TripDataModel)

    fun createOtherTrip(tripData: TripDataModel)

    fun getAllTrips(): List<TripDataModel>

    fun getAllOtherUsersTrips(): List<TripDataModel>

    fun getFilteredTrip(
        sourceName: String = "", destination: String = "",
        travelDate: String = "",
    ): List<TripDataModel>

    fun askToJoinTrip(tripId: String, userId: String)

    fun allowToJoinTrip(tripId: String, case: Int)

    fun markFavourite(tripId: String)

    fun getFavouriteTripList(): List<TripDataModel>
}