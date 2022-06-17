package com.example.application

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.application.Fragment.bitcointFragment
import com.example.application.Fragment.catFragment
import com.example.application.Fragment.catInfoFragment
import com.example.application.databinding.ActivityMainBinding
import com.example.application.databinding.FragmentBitcointBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
var state:Fragment? = null
fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, fragment)
        .commit()
}

fun AppCompatActivity.returnToHome() {
    supportFragmentManager.popBackStackImmediate(
        null,
        FragmentManager.POP_BACK_STACK_INCLUSIVE
    )
}

fun MainActivity.showFragmentForTest(mBinding: ActivityMainBinding) {
    mBinding.bottomMenu.setOnItemSelectedListener {
        when (it.itemId) {
            R.id.cat -> replaceFragment(catFragment())
            R.id.bitcoin -> replaceFragment(bitcointFragment())
            R.id.home -> returnToHome()
        }
        true
    }
    returnBack(mBinding)
}
fun MainActivity.returnBack(mBinding: ActivityMainBinding){
    mBinding.mainButtomBack.setOnClickListener {
        supportFragmentManager.popBackStack()
    }
}
fun checkSelectedIcon(){

}
fun MainActivity.setDefaultSelectedBottomNavigation(){
    val mBottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_menu)
    mBottomNavigationView.menu.findItem(R.id.home).setChecked(true)
}
