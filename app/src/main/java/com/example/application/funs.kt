package com.example.application

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.application.Fragment.bitcointFragment
import com.example.application.Fragment.catFragment
import com.example.application.Fragment.catInfoFragment
import com.example.application.Fragment.detet
import com.example.application.databinding.ActivityMainBinding
import com.example.application.databinding.FragmentBitcointBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@SuppressLint("UseRequireInsteadOfGet")
fun AppCompatActivity.replaceFragment(fragment: Fragment, tag: String) {
    //if (!fragment.isStateSaved)//DELETE AFTER TEST
       // Toast.makeText(this, "YES", Toast.LENGTH_LONG).show()
  var frag: Fragment? = supportFragmentManager.findFragmentByTag(tag)
    if(frag != null){
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.container, frag, tag)
            .commit()
        Toast.makeText(this, "YES", Toast.LENGTH_LONG).show()
    } else {
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.container, fragment, tag)
            .commit()
    }
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
            R.id.cat -> replaceFragment(catFragment(), "cat")
            R.id.bitcoin -> replaceFragment(bitcointFragment(), "bitcoin")
            R.id.home -> replaceFragment(detet(), "home")
        }
        true
    }
    returnBack(mBinding)
}

fun MainActivity.returnBack(mBinding: ActivityMainBinding) {
    mBinding.mainButtomBack.setOnClickListener {
        supportFragmentManager.popBackStack()
    }
}

fun MainActivity.setDefaultSelectedBottomNavigation() {
    val mBottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_menu)
    mBottomNavigationView.menu.findItem(R.id.home).setChecked(true)
}
