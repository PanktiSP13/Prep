import com.google.gson.Gson
import com.pankti.l1programmingquestions.tripmamanagement.TripDataModel
import com.pankti.l1programmingquestions.tripmamanagement.UserDataModel
import com.pankti.l1programmingquestions.tripmamanagement.TripRepository
import com.pankti.l1programmingquestions.tripmamanagement.TripRepositoryImpl


fun dummyTripDataModel(id: String) = TripDataModel(
    id = id,
    tripName = "Vacation",
    startDate = "10/03/25",
    endDate = "12/03/25",
    source = "Kerala",
    destination = "Madurai",
    itinerary = "ABC",
    isFavourite = false
)

fun main()  {

    val tripRepository: TripRepository = TripRepositoryImpl()

    val user1 = UserDataModel(userId = "12", name = "Pankti", age = "26", gender = "female")
    val user2 = UserDataModel(userId = "13", name = "Yash", age = "20", gender = "male")

    //create
    repeat(2) {
        tripRepository.createTrip(dummyTripDataModel("${it + 1}"))
    }
    //getTripList
    tripRepository.getAllTrips().print("create trips")

    //create other role
    repeat(5) {
        tripRepository.createOtherTrip(dummyTripDataModel("${it + 6}"))
    }

    //get other Trip List
    tripRepository.getAllOtherUsersTrips().print("create other user trips")

    //search
    tripRepository.getFilteredTrip(sourceName = "Kerala").print("search : source name")

    //search
    tripRepository.getFilteredTrip(destination = "Madurai").print("search : destination name")

    //filter based on date
    tripRepository.getFilteredTrip(travelDate = "12/03/25").print("filter list ")


    tripRepository.markFavourite("2")
    tripRepository.getAllTrips().print("marked favourite")


    tripRepository.askToJoinTrip("7", "12")
    tripRepository.getAllOtherUsersTrips().print("asked to join the trip")



    tripRepository.allowToJoinTrip("6", 1)
    tripRepository.getAllOtherUsersTrips().print("allow user to join the trip")


    tripRepository.allowToJoinTrip("8", 2)
    //getTripList
    tripRepository.getAllOtherUsersTrips().print("reject user request to join the trip")

}

fun List<TripDataModel>.print(topic: String) {
    println(" $topic ------->  ${Gson().toJson(this)}")
    println()
    println()
}