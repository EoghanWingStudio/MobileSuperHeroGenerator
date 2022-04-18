package com.eoghandev.randomsuperherogenerator


import android.content.Intent
import android.widget.Button
import com.eoghandev.randomsuperherogenerator.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val superHeroBtn = findViewById<Button>(R.id.superHeroBtn)
//        superHeroBtn.setOnClickListener{
//            superHeroChoice()
//        }
    }


    public fun superHeroChoice(view: android.view.View) {
        val intent = Intent(this, SuperHeroGenerator::class.java)
        Toast.makeText(this, "Test", Toast.LENGTH_LONG)

        startActivity(intent)
    }
}