package com.pankti.l1programmingquestions

import android.app.Application

class MyApplication : Application() {

    //create a thread-safe singleton instance of the Application class

    companion object {

        // The volatile keyword ensures that changes to the instance variable are
        // visible across all threads without caching issues.

        @Volatile
        private var instance: MyApplication? = null


        // The use of synchronized ensures that the singleton instance is initialized only once,
        // even if multiple threads try to access the getInstance() method simultaneously.
        fun getInstance(): MyApplication {
            return if (instance != null) instance as MyApplication else synchronized(this) { MyApplication() }
        }

    }

    override fun onCreate() {
        super.onCreate()
        // Initializing the instance in onCreate to ensure it is initialized with the Application context
        if (instance == null) {
            instance = this
        }
    }


}