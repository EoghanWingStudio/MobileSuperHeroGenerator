package com.eoghandev.randomsuperherogenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.eoghandev.randomsuperherogenerator.models.comics.Comic
import com.eoghandev.randomsuperherogenerator.models.comics.ComicResponse
import com.eoghandev.randomsuperherogenerator.models.hero.HeroModel
import com.eoghandev.randomsuperherogenerator.service.MarvelService
import com.eoghandev.randomsuperherogenerator.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val url = "https://gateway.marvel.com/v1/public/comics?limit=10&ts=1&apikey=dbfc4354c405c403c362f63cc60242a1&hash=7cfdc10da4f83dd1de3aaf98894c9f86"
class ComicBookGenerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_book_generator)
    }

    fun generateComic(view: android.view.View) {
        val resultsView = findViewById<TextView>(R.id.comicText)

        val comicService = ServiceBuilder.buildService(MarvelService::class.java)
        val requestCall = comicService.getComics()

        requestCall.enqueue(object : Callback<ComicResponse>{
            override fun onResponse(
                call: Call<ComicResponse>,
                response: Response<ComicResponse>
            ) {
                if (response.isSuccessful){
                    val comicList = response.body()!!
                    resultsView.text = comicList.toString()
                }
            }
            override fun onFailure(
                call: Call<ComicResponse>,
                t: Throwable) {
                resultsView.text = "Error " + t
            }
        })
    }
}