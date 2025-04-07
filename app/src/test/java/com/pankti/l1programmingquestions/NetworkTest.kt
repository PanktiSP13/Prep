package com.pankti.l1programmingquestions

import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkTest{

    @Test fun get_retrofit_service(){
        assertEquals(true, Network.apiService != null)
    }

}