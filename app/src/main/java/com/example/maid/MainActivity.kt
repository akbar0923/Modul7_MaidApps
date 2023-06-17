package com.example.maid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.maid.fragment.HomeFragment
import com.example.maid.fragment.ProfileFragment
import com.example.maid.fragment.UpcomingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.action_bar_layout)

        val homeFragment = HomeFragment()
        val upcomingFragment = UpcomingFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.BottomNavMenu)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.upcoming -> makeCurrentFragment(upcomingFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }

            true
        }

        // Memastikan mode malam tetap berlaku saat aplikasi dijalankan
        if (isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Tambahkan kode lainnya di sini
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }

    private fun isNightModeEnabled(): Boolean {
        val sharedPref = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("night_mode_enabled", false)
    }
}
