package com.eoghandev.randomsuperherogenerator

import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.eoghandev.randomsuperherogenerator.models.comics.Comic
import com.eoghandev.randomsuperherogenerator.models.comics.ComicResponse
import com.eoghandev.randomsuperherogenerator.service.MarvelService
import com.eoghandev.randomsuperherogenerator.service.ServiceBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random


class ComicBookGenerator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_book_generator)
    }

    fun generateComic(view: android.view.View) {
        val resultsView = findViewById<TextView>(R.id.comicText)
        val heroImage = findViewById<ImageView>(R.id.comicPic)

        val comicService = ServiceBuilder.buildService(MarvelService::class.java)
        val requestCall = comicService.getComics()

        requestCall.enqueue(object : Callback<ComicResponse>{


            override fun onResponse(
                call: Call<ComicResponse>,
                response: Response<ComicResponse>
            ) {
                if (response.isSuccessful){
                    var comicList = response.body()!!.data?.results
                    //resultsView.text = comicList.data?.results?.get(0)?.title

                    var randomComic = randomSelection(comicList)

                    var displayData = populateScreen(randomComic, resultsView, heroImage)

                }
            }
            override fun onFailure(
                call: Call<ComicResponse>,
                t: Throwable) {
                resultsView.text = "Error " + t
            }
        })
    }

    private fun populateScreen(randomComic: Comic?, resultsView: TextView, heroImage: ImageView): Boolean {

        try {

            resultsView.text = randomComic?.title

            val url = randomComic?.thumbnail?.path + "/portrait_medium." + randomComic?.thumbnail?.extension
            Picasso.with(this).load(url).into(heroImage)


            return true
        }catch (e: Exception){
            return false
        }

    }

    private fun randomSelection(comicList: List<Comic>?): Comic? {

        val randIndex = comicList?.let { Random.nextInt(it.size) }
        return randIndex?.let { comicList?.get(it) }
    }
}