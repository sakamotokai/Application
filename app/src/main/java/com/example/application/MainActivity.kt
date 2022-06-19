package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application.Fragment.homeFragment
import com.example.application.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        showFragmentForTest(mBinding)
        replaceFragment(homeFragment(),"home")
        setDefaultSelectedBottomNavigation()
    }
}