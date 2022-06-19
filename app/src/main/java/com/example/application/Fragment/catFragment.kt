package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application.*
import com.example.application.databinding.FragmentCatBinding


class catFragment : Fragment() {

    val adapter = catAdapter()
    lateinit var mBinding: FragmentCatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCatBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init() {
        mBinding.apply {
            catRecycleView.layoutManager = LinearLayoutManager(context)
            catRecycleView.adapter = adapter
            catAddInfo.setOnClickListener {
                viewFragment().showCatInfo(catContainerForText)
                val item = catItem(catContainerForText.text.toString())
                adapter.addItem(item)
            }
        }
    }
}