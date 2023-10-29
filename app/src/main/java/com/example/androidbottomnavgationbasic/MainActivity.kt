package com.example.androidbottomnavgationbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var bottomNavigationView: BottomNavigationView

    var homeFragment: HomeFragment = HomeFragment()
    var profileFragment: ProfileFragment = ProfileFragment()
    var settingFragment: SettingFragment = SettingFragment()

    //method overriding, running main view
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationViewComponent)
        bottomNavigationView.setOnItemSelectedListener(this)

    }

    //method overriding, if there selected item in bottom navigation
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.homeItem) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, homeFragment).commit()
            return true
        } else if (item.itemId == R.id.profileItem) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, profileFragment).commit()
            return true
        } else if (item.itemId == R.id.settingItem) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, settingFragment).commit()
            return true
        }
        return false
    }
}