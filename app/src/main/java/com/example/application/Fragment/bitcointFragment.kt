package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.databinding.FragmentBitcointBinding
import com.example.application.staticBitcoin
import com.example.application.viewFragment


class bitcointFragment : Fragment() {

    lateinit var mBinding:FragmentBitcointBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       mBinding = FragmentBitcointBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.bitcoinCourseOfBitcoin.setText(staticBitcoin.returnData)
        mBinding.bitcoinDoubleInfo.setText(staticBitcoin.bitcoinInfoData)
        onClickButtom()
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