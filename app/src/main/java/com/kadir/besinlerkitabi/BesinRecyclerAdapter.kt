package com.kadir.besinlerkitabi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kadir.besinlerkitabi.databinding.ActivityMainBinding.inflate
import kotlinx.android.synthetic.main.besin_recycler_row.view.*
import java.util.zip.Inflater

class BesinRecyclerAdapter(val besinListesi: ArrayList<Besin>): RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.isim.text=besinListesi.get(position).besinisim
        holder.itemView.kalori.text=besinListesi.get(position).besinkalori
        //görsel kısmı eklenecek

        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(0)
            Navigation.findNavController(it).navigate(action)
        }
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel, placeholderYap(holder.itemView.context))

    }
    override fun getItemCount(): Int {
        return besinListesi.size
    }
    fun besinlistesiniguncelle(yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()


    }

}