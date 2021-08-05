package com.example.expertmovie.favorite_film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expertmovie.favorite_film.databinding.ActivityFavoriteBinding
import com.example.expertmovie.favorite_film.di.favoriteModule
import org.koin.core.context.loadKoinModules


class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    companion object {
        private const val TITLE = "favorite"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.favorite_activity, FavFilmFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
        supportActionBar?.elevation = 0f
        supportActionBar?.title = TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finishAfterTransition()
        return super.onSupportNavigateUp()
    }

}