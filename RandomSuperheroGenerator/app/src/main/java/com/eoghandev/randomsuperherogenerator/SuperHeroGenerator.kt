package com.eoghandev.randomsuperherogenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.eoghandev.randomsuperherogenerator.models.hero.HeroModel
import okhttp3.*
import java.io.IOException

class SuperHeroGenerator : AppCompatActivity() {

    //private val queue = Volley.newRequestQueue(this)
    private val url = "https://gateway.marvel.com/v1/public/characters?limit=10&ts=1&apikey=dbfc4354c405c403c362f63cc60242a1&hash=7cfdc10da4f83dd1de3aaf98894c9f86"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_generator)



    }

     fun generateHero(view: android.view.View){
        val resultsView = findViewById<TextView>(R.id.heroText)



     }
}