package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.MainAdapter
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView_main: RecyclerView // Define recyclerViewMain as a class-level property


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main = findViewById<RecyclerView>(R.id.recyclerView_main)
        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fetchJson()


    }

    fun fetchJson() {
        println("Attempting to Fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)


                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)

                }

            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}

