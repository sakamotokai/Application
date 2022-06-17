package com.example.application.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application.databinding.FragmentDetetBinding
import com.example.application.viewFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [detet.newInstance] factory method to
 * create an instance of this fragment.
 */
class detet : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var mBinding: FragmentDetetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetetBinding.inflate(layoutInflater,container,false)
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
            mBinding.bitcoinCourseOfBitcoin.text = mBinding.bitcoinUSDButtom.text
        }
        mBinding.bitcoinEUROButtom.setOnClickListener{
            viewFragment().showCourse(mBinding,"EUR")
            viewFragment().showDopInfoCoin(mBinding,"EUR")
            mBinding.bitcoinCourseOfBitcoin.text = mBinding.bitcoinEUROButtom.text
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            detet().apply {
               val arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
                val fragment = detet()
                fragment.arguments = arguments
                return fragment
            }
    }
}