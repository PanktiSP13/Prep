package com.pankti.l1programmingquestions.tripmamanagement



class TripRepositoryImpl : TripRepository {

    private var myTripList = mutableListOf<TripDataModel>()

    // to maintain user 2 action
    private var othersTripList = mutableListOf<TripDataModel>()

    override fun createTrip(tripData: TripDataModel) {
        myTripList.add(tripData)
    }

    override fun createOtherTrip(tripData: TripDataModel) {
        othersTripList.add(tripData)
    }

    override fun getAllTrips() = myTripList

    override fun getAllOtherUsersTrips(): List<TripDataModel> = othersTripList


    override fun getFilteredTrip(
        sourceName: String, destination: String,
        travelDate: String,
    ): List<TripDataModel> {
        val filteredList = myTripList.filter {
            (it.source == (sourceName ?: "")) && (it.destination == (destination ?: "")) &&
                    (it.startDate == (travelDate ?: "") || it.endDate == (travelDate ?: ""))
        }
        return filteredList
    }

    override fun askToJoinTrip(tripId: String, userId: String) {
        // find the selected trip from trip id and set joining status to pending ( asked to join but pending for approval)
        othersTripList.find { it.id == tripId }?.let { it.joiningTripStatus = JoinTripStatus.PENDING }
    }

    // case 1 : approve, case 2: reject
    override fun allowToJoinTrip(tripId: String, case: Int) {
        othersTripList.find { it.id == tripId }?.apply {
            allowForTrip =  if (case == 1)  true else false
            joiningTripStatus = if (case == 1) JoinTripStatus.APPROVED else JoinTripStatus.REJECTED
        }

    }

    override fun markFavourite(tripId: String) {
        myTripList.find { it.id == tripId }?.apply { isFavourite = !isFavourite }
    }

    override fun getFavouriteTripList(): List<TripDataModel> = myTripList.filter { it.isFavourite }


}

