package com.example.maid.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maid.DetailpricelistActivity
import com.example.maid.*
import com.example.maid.adapter.SliderAdapter
import com.example.maid.adapter.pricelistAdapter
import com.example.maid.data.pricelist
import com.example.maid.R
import com.smarteist.autoimageslider.SliderView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: pricelistAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: List<pricelist>

    lateinit var imageurl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.setHasFixedSize(true)
        adapter = pricelistAdapter(requireContext(), movieList) { movie ->
            val intent = Intent(requireContext(), DetailpricelistActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, movie)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        sliderView = view.findViewById(R.id.imageSlider)

        imageurl = ArrayList()
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slide)
        imageurl.add("android.resource://" + requireContext().packageName + "/" + R.drawable.slide1)


        sliderAdapter = SliderAdapter(imageurl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()
    }

    private fun dataInitialize() {

        movieList = listOf<pricelist>(
            pricelist(
                R.drawable.pubg,
                namepricelist = "Pubg Mobile",
                descpricelist = "Selamat datang di Store Ma.id, destinasi terbaik untuk mendapatkan voucher top-up PUBG dengan cepat dan mudah! Kami adalah toko online yang menyediakan berbagai pilihan voucher top-up untuk memenuhi kebutuhan Anda dalam meningkatkan pengalaman bermain game PUBG yang seru ini." +
                        "\nDengan voucher top-up PUBG dari Store Ma.id, Anda dapat mengisi saldo UC (Unknown Cash) dalam akun game PUBG Anda. UC adalah mata uang virtual yang digunakan di PUBG untuk membeli berbagai item dalam game, seperti skin senjata, pakaian, aksesori, atau paket loot yang menarik. Dengan menggunakan voucher top-up kami, Anda dapat dengan mudah meningkatkan inventaris Anda dan memperoleh keuntungan tambahan di medan pertempuran PUBG."
            ),
            pricelist(
                R.drawable.ml,
                namepricelist = "Mobile Legends",
                descpricelist = "Selamat datang di Store Ma.id, tujuan utama Anda untuk mendapatkan voucher game Mobile Legends dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Mobile Legends untuk memenuhi kebutuhan Anda dalam mengisi ulang saldo dalam game yang menarik ini.\n" +
                        "\n" +
                        "Dengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda." +
                        "\nDengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda."
            ),
            pricelist(
                R.drawable.valorant,
                namepricelist = "Valorant",
                descpricelist = "Selamat datang di Store Ma.id, tempat terbaik untuk mendapatkan voucher game Valorant dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Valorant untuk memenuhi kebutuhan Anda dalam mengisi saldo dan meningkatkan pengalaman bermain game FPS yang seru ini.\n" +
                        "Dengan voucher game Valorant dari Store Ma.id, Anda dapat mengakses berbagai fitur tambahan, senjata, skin, atau item lainnya yang akan meningkatkan tampilan dan kinerja karakter Anda dalam pertempuran. Voucher ini memungkinkan Anda untuk mengisi ulang saldo Valorant Points (VP) dalam akun game Anda, sehingga Anda dapat dengan mudah membeli apa pun yang Anda butuhkan di dalam game."
            ),
            pricelist(
                R.drawable.sausage,
                namepricelist = "Sausage",
                descpricelist = "Selamat datang di Store Ma.id, tempat terbaik untuk mendapatkan voucher game Sausage dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Sausage untuk memenuhi kebutuhan Anda dalam mengisi saldo dan meningkatkan pengalaman bermain game FPS yang seru ini.\n" +
                        "Dengan voucher game Sausage dari Store Ma.id, Anda dapat mengakses berbagai fitur tambahan, senjata, skin, atau item lainnya yang akan meningkatkan tampilan dan kinerja karakter Anda dalam pertempuran. Voucher ini memungkinkan Anda untuk mengisi ulang saldo Valorant Points (VP) dalam akun game Anda, sehingga Anda dapat dengan mudah membeli apa pun yang Anda butuhkan di dalam game."

            )
        )
    }
}