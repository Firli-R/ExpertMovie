package com.example.expertmovie.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.expertmovie.R
import com.example.expertmovie.databinding.ActivityMainBinding
import com.example.expertmovie.film.FilmFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity, FilmFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
            supportActionBar?.elevation = 0f
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.fav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.fav_menu ->{
                val uri = Uri.parse("expertmovie://favorite_film")
                startActivity(Intent(Intent.ACTION_VIEW, uri))


            }
        }
        return super.onOptionsItemSelected(item)
    }

}