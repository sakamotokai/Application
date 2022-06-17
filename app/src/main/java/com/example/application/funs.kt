package com.example.application

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.application.Fragment.bitcointFragment
import com.example.application.Fragment.catFragment
import com.example.application.databinding.ActivityMainBinding
import com.example.application.databinding.FragmentBitcointBinding

fun AppCompatActivity.replaceFragment(fragment:Fragment){
    supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container,fragment).commit()
}
fun MainActivity.showFragmentForTest(mBinding:ActivityMainBinding){
    mBinding.bottomMenu.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.cat -> replaceFragment(catFragment())
            R.id.bitcoin -> replaceFragment(bitcointFragment())
        }
        true
    }
}
