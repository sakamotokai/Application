package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.databinding.FragmentHomeBinding
import com.example.application.getApiData

class homeFragment : Fragment() {

    lateinit var mBinding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startDataBitcoinFragmetn()
    }
    fun startDataBitcoinFragmetn(){
        getApiData().getData_bitcoin(mBinding.textView,"USD")
        getApiData().getDopData_bitcoin(mBinding.textView,"USD")
    }
}