package com.eoghandev.randomsuperherogenerator.service

import com.eoghandev.randomsuperherogenerator.models.comics.ComicResponse
import com.eoghandev.randomsuperherogenerator.models.hero.Data
import retrofit2.Call
import retrofit2.http.GET

interface MarvelService {

    @GET("heroes")
    fun getHeroes(): Call<List<Data>>

    @GET("comics?&ts=1&apikey=dbfc4354c405c403c362f63cc60242a1&hash=7cfdc10da4f83dd1de3aaf98894c9f86")
    fun getComics(): Call<ComicResponse>
}