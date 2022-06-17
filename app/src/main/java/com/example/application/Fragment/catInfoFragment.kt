package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.R
import com.example.application.databinding.FragmentCatBinding
import com.example.application.databinding.FragmentCatInfoBinding


class catInfoFragment : Fragment() {
    lateinit var mBinding:FragmentCatInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCatInfoBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }
}