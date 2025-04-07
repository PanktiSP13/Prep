package com.pankti.l1programmingquestions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object Network {

    private const val baseUrl = "https://mocki.io"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client())
        .baseUrl(baseUrl)
        .build()

    private fun client() =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).addInterceptor(
            Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder()
                        .header("Content-Type", "application/json")
                        .build()
                )
            }).build()

    var apiService: APIService = retrofit.create(APIService::class.java)

}


interface APIService {
    @GET("v1/get-bus-list")
    suspend fun getBusList(): BusDataModel
}

class NetworkCallDemo() {

    private val _busDataModel = MutableLiveData<BusDataModel>()
    val busDataModel:LiveData<BusDataModel> = _busDataModel

    suspend fun getBusData() {
        flow {
            emit(Network.apiService.getBusList())
        }.catch {
            Log.e("@@@@@", "getBusData: ${it.message}")
        }.collect { data ->
            _busDataModel.value = data
        }
    }

    fun convertJsonData(data : String):BusDataModel{
        val type = object  : TypeToken<BusDataModel>(){}.type
        return Gson().fromJson(data,type)
    }
}