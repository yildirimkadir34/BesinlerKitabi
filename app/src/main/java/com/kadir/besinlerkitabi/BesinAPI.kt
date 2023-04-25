package com.kadir.besinlerkitabi

import android.telecom.Call
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {
    //GET, POST
    //https://github.com/atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json
    //BASE_URL ->https://github.com/
    //atilsamancioglu/BTK20-JSONVeriSeti/blob/master/besinler.json

    @GET("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin() :Single <List<Besin>>

}