package com.example.application

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.application.databinding.FragmentBitcointBinding


class viewFragment:Fragment() {
    fun showCourse(binding: FragmentBitcointBinding, coin:String){
        getApiData().getData_bitcoin(binding.bitcoinCourseOfBitcoin, coin)
    }
    fun showDopInfoCoin(binding: FragmentBitcointBinding, coin:String){
        getApiData().getDopData_bitcoin(binding.bitcoinDoubleInfo, coin)
    }
    fun showCatInfo(text:TextView){
        getApiData().getData_cat(text)
    }
}