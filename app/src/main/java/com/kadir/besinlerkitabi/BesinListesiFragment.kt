package com.kadir.besinlerkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_besin_listesi.*


class BesinListesiFragment : Fragment() {

    private lateinit var viewModel: BesinListesiviewmodel
    private val recyclerBesinAdapter= BesinRecyclerAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_listesi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(BesinListesiviewmodel::class.java)
        viewModel.refreshData()

        besinlistRecycler.layoutManager = LinearLayoutManager(context)
        besinlistRecycler.adapter= recyclerBesinAdapter

        swiperefreshlayout.setOnRefreshListener {
            besinloading.visibility=View.VISIBLE
            besinHataMesaji.visibility=View.GONE
            besinlistRecycler.visibility=View.GONE
            viewModel.refreshData()
            swiperefreshlayout.isRefreshing=false
        }

        observeLiveData()



    }
    fun observeLiveData(){
        viewModel.besinler.observe(viewLifecycleOwner, Observer {
            it?.let {

                besinlistRecycler.visibility=View.VISIBLE
                recyclerBesinAdapter.besinlistesiniguncelle(it)
            }
        })
        viewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    besinHataMesaji.visibility = View.VISIBLE
                }
                else{
                    besinHataMesaji.visibility = View.GONE
                }
            }
        })
        viewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    besinlistRecycler.visibility = View.GONE
                    besinHataMesaji.visibility = View.GONE
                    besinloading.visibility = View.VISIBLE
                }
                else{
                    besinloading.visibility = View.GONE
                }
            }
        })

    }


}