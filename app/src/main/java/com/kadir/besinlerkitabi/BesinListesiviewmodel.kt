package com.kadir.besinlerkitabi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

class BesinListesiviewmodel: ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji= MutableLiveData<Boolean>()
    val besinYukleniyor=MutableLiveData<Boolean>()

    private val besinAPIServis = BesinAPIServis()
    private val disposable = CompositeDisposable()


    fun refreshData(){
        verileriInternettenAl()
    }

    private fun verileriInternettenAl(){
        besinYukleniyor.value = true
        disposable.add(
            besinAPIServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>(){
                    override fun onSuccess(t: List<Besin>) {
                        besinler.value = t
                        besinHataMesaji.value=false
                        besinYukleniyor.value=false
                    }

                    override fun onError(e: Throwable) {
                        besinHataMesaji.value=true
                        besinYukleniyor.value=false
                        e.printStackTrace()
                    }

                })

        )
    }
}