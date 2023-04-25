package com.kadir.besinlerkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.kadir.besinlerkitabi.databinding.ActivityMainBinding.inflate
import com.kadir.besinlerkitabi.databinding.FragmentBesinListesiBinding.inflate
import kotlinx.android.synthetic.main.fragment_besin_detayi.*


class BesinDetayiFragment : Fragment() {
    private lateinit var viewModel: BesinDetayiViewModel
    private var besinId=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
        viewModel.roomVerisiniAl()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detayi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinID
            println(besinId)

        }
        observeLiveData()

    }
    fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                besinIsmi.text = it.besinisim
                besinKalori.text=it.besinkalori
                besinkarb.text=it.besinkarb
                besinprotein.text=it.besinkarb
                besinyag.text=it.besinyag
            }
        })
    }


}