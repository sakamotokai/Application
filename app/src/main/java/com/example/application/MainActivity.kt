package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.application.Fragment.bitcointFragment
import com.example.application.Fragment.catFragment
import com.example.application.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

    open class MainActivity : AppCompatActivity() {
        lateinit var mBinding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mBinding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(mBinding.root)
            showFragmentForTest(mBinding)
        }
    }