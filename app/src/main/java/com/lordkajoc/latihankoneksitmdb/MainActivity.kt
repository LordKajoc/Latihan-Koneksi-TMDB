package com.lordkajoc.latihankoneksitmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.latihan_retrofit.network.ApiClient
import com.lordkajoc.latihankoneksitmdb.databinding.ActivityMainBinding
import com.lordkajoc.latihankoneksitmdb.model.GetAllFilmResponse
import com.lordkajoc.latihankoneksitmdb.model.GetAllFilmTMDB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listMovie = mutableListOf<GetAllFilmResponse>()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getFilm()
    }

    fun getFilm() {
        ApiClient.instance.getmovie(APIKEY = "7f40338572c7bcecdd056ae5622e950d", PAGE = 1)
            .enqueue(object : Callback<GetAllFilmTMDB<GetAllFilmResponse>> {
                override fun onResponse(
                    call: Call<GetAllFilmTMDB<GetAllFilmResponse>>,
                    response: Response<GetAllFilmTMDB<GetAllFilmResponse>>
                ) {
                    if (response.isSuccessful) {
                        binding.rvlistfilm.layoutManager = LinearLayoutManager(
                            this@MainActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        val filmResponse = response.body()
                        if (filmResponse != null) {
                            listMovie.addAll(filmResponse.results)
                            binding.rvlistfilm.adapter = AdapterFilm(listMovie)
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT)
                            .show()
                    }

                }

                override fun onFailure(
                    call: Call<GetAllFilmTMDB<GetAllFilmResponse>>,
                    t: Throwable
                ) {
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }

            })

    }

}
