package com.example.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.application.databinding.FragmentCatBinding
import com.example.application.databinding.FragmentCatInfoBinding

class catAdapter:RecyclerView.Adapter<catAdapter.ViewHolder>() {
    val list = ArrayList<catItem>()
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = FragmentCatInfoBinding.bind(item)
        fun bind(catitem:catItem) = with(binding){
            catInfoText.text = catitem.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_cat_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun addItem(item: catItem){
        list.add(item)
        notifyDataSetChanged()
    }

}