package com.example.maid.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maid.UpcomingActivity
import com.example.maid.adapter.UpcomingAdapter
import com.example.maid.data.UpcomingData
import com.example.maid.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpcomingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpcomingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: UpcomingAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var upcomingList: List<UpcomingData>

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
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment UpcomingFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            UpcomingFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        adapter = UpcomingAdapter(requireContext(), upcomingList) { upcoming ->
            val intent = Intent(requireContext(), UpcomingActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, upcoming)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        upcomingList = listOf<UpcomingData>(
            UpcomingData(
                R.drawable.pubg,
                nameharga = "Pubg Mobile",
                descharga = "Selamat datang di Store Ma.id, destinasi terbaik untuk mendapatkan voucher top-up PUBG dengan cepat dan mudah! Kami adalah toko online yang menyediakan berbagai pilihan voucher top-up untuk memenuhi kebutuhan Anda dalam meningkatkan pengalaman bermain game PUBG yang seru ini." +
                        "\nDengan voucher top-up PUBG dari Store Ma.id, Anda dapat mengisi saldo UC (Unknown Cash) dalam akun game PUBG Anda. UC adalah mata uang virtual yang digunakan di PUBG untuk membeli berbagai item dalam game, seperti skin senjata, pakaian, aksesori, atau paket loot yang menarik. Dengan menggunakan voucher top-up kami, Anda dapat dengan mudah meningkatkan inventaris Anda dan memperoleh keuntungan tambahan di medan pertempuran PUBG."
            ),
            UpcomingData(
                R.drawable.ml,
                nameharga = "Mobile Legends",
                descharga = "Selamat datang di Store Ma.id, tujuan utama Anda untuk mendapatkan voucher game Mobile Legends dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Mobile Legends untuk memenuhi kebutuhan Anda dalam mengisi ulang saldo dalam game yang menarik ini.\n" +
                        "\n" +
                        "Dengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda." +
                        "\nDengan voucher game Mobile Legends dari Store Ma.id, Anda dapat meningkatkan pengalaman bermain Mobile Legends Anda dengan lebih banyak opsi dan keuntungan. Anda dapat menggunakan voucher ini untuk membeli berbagai item dalam game, seperti skin pahlawan yang keren, perlengkapan yang unik, dan aksesori yang menambah tampilan dan kemampuan karakter Anda."
            ),
            UpcomingData(
                R.drawable.valorant,
                nameharga = "Valorant",
                descharga = "Selamat datang di Store Ma.id, tempat terbaik untuk mendapatkan voucher game Valorant dengan mudah dan cepat! Kami adalah toko online yang menyediakan berbagai voucher game Valorant untuk memenuhi kebutuhan Anda dalam mengisi saldo dan meningkatkan pengalaman bermain game FPS yang seru ini.\n" +
                        "Dengan voucher game Valorant dari Store Ma.id, Anda dapat mengakses berbagai fitur tambahan, senjata, skin, atau item lainnya yang akan meningkatkan tampilan dan kinerja karakter Anda dalam pertempuran. Voucher ini memungkinkan Anda untuk mengisi ulang saldo Valorant Points (VP) dalam akun game Anda, sehingga Anda dapat dengan mudah membeli apa pun yang Anda butuhkan di dalam game."
            ),
        )
    }
}