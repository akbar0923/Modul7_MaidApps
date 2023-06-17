package com.example.maid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.maid.data.pricelist
import com.example.maid.fragment.HomeFragment


class DetailpricelistActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pricelist)

        val youtube = findViewById<Button>(R.id.youtube)
        youtube.setOnClickListener {
            val url = "https://www.instagram.com/ma.iid/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        val wikipedia = findViewById<Button>(R.id.wikipedia)
        wikipedia.setOnClickListener {
            val url =
                "https://api.whatsapp.com/send/?phone=%2B6281779990061&text&type=phone_number&app_absent=0"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val music = intent.getParcelableExtra<pricelist>(HomeFragment.INTENT_PARCELABLE)

        val imgpricelist = findViewById<ImageView>(R.id.img_item_photo)
        val namepricelist = findViewById<TextView>(R.id.tv_item_name)
        val descpricelist = findViewById<TextView>(R.id.tv_item_description)



        imgpricelist.setImageResource(music?.imgpricelist!!)
        namepricelist.text = music.namepricelist
        descpricelist.text = music.descpricelist

    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}
