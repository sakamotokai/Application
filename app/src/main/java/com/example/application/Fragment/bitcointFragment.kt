package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.R
import com.example.application.databinding.FragmentBitcointBinding
import com.example.application.viewFragment


class bitcointFragment : Fragment() {

    lateinit var mBinding:FragmentBitcointBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       mBinding = FragmentBitcointBinding.inflate(layoutInflater,container,false)
        defaultState()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickButtom()
    }
    fun defaultState(){
        viewFragment().showCourse(mBinding,"USD")
        viewFragment().showDopInfoCoin(mBinding,"USD")
    }
    fun onClickButtom(){
        mBinding.bitcoinUSDButtom.setOnClickListener{
            viewFragment().showCourse(mBinding,"USD")
            viewFragment().showDopInfoCoin(mBinding,"USD")
        }
        mBinding.bitcoinEUROButtom.setOnClickListener{
            viewFragment().showCourse(mBinding,"EUR")
            viewFragment().showDopInfoCoin(mBinding,"EUR")
        }
    }

}