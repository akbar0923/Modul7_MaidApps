package com.example.maid.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.maid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : Fragment() {
    private lateinit var sharedPref: SharedPreferences
    private lateinit var btnSwitchMode: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        btnSwitchMode = view.findViewById(R.id.btnSwitchMode)
        if (isNightModeEnabled()) {
            btnSwitchMode.setImageResource(R.drawable.ic_sunny)
        } else {
            btnSwitchMode.setImageResource((R.drawable.ic_mode))
        }

        updateSwitchModeButton()

        btnSwitchMode.setOnClickListener {
            toggleNightMode(!isNightModeEnabled())
            updateSwitchModeButton()
        }
    }

    private fun isNightModeEnabled(): Boolean {
        return sharedPref.getBoolean("night_mode_enabled", false)
    }

    private fun toggleNightMode(enableNightMode: Boolean) {
        sharedPref.edit().putBoolean("night_mode_enabled", enableNightMode).apply()
        if (enableNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun updateSwitchModeButton() {
        if (isNightModeEnabled()) {
            btnSwitchMode.contentDescription = "Mode Gelap"
        } else {
            btnSwitchMode.contentDescription = "Mode Terang"
        }
    }
}

