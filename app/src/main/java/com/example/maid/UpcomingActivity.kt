package com.example.maid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.maid.data.UpcomingData
import com.example.maid.fragment.UpcomingFragment

class UpcomingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upcoming_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val upcoming = intent.getParcelableExtra<UpcomingData>(UpcomingFragment.INTENT_PARCELABLE)

        val imgharga = findViewById<ImageView>(R.id.imgharga)
        val nameharga = findViewById<TextView>(R.id.namaharga)
        val descharga = findViewById<TextView>(R.id.deskharga)

        imgharga.setImageResource(upcoming?.imgharga!!)
        nameharga.text = upcoming.nameharga
        descharga.text = upcoming.descharga
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}