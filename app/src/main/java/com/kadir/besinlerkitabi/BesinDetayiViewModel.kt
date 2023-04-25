package com.kadir.besinlerkitabi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BesinDetayiViewModel: ViewModel() {
    val besinLiveData = MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        val muz = Besin ("muz","100","10","10","1","www.test.com")
        besinLiveData.value = muz
    }


}
