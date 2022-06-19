package com.example.application

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.application.Fragment.bitcointFragment
import com.example.application.Fragment.catFragment
import com.example.application.Fragment.homeFragment
import com.example.application.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

fun AppCompatActivity.replaceFragment(fragment: Fragment, tag: String) {
    var frag: Fragment? = supportFragmentManager.findFragmentByTag(tag)
    if (frag != null) {
        supportFragmentManager.beginTransaction().replace(R.id.container, frag, tag).commit()
    } else {
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.container, fragment, tag)
            .commit()
    }
}

fun AppCompatActivity.showFragmentForTest(mBinding: ActivityMainBinding) {
    mBinding.bottomMenu.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.cat -> replaceFragment(catFragment(), "cat")
            R.id.bitcoin -> replaceFragment(bitcointFragment(), "bitcoin")
            R.id.home -> replaceFragment(homeFragment(), "home")
        }
        true
    }
}

fun MainActivity.setDefaultSelectedBottomNavigation() {
    val mBottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_menu)
    mBottomNavigationView.menu.findItem(R.id.home).setChecked(true)
}
