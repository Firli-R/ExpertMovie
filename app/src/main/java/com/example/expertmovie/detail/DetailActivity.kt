package com.example.expertmovie.detail


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.expertmovie.R
import com.example.core.domain.model.EntityItem
import com.example.expertmovie.databinding.ActivityDetailBinding
import com.example.expertmovie.databinding.ContentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ContentDetailBinding
    private lateinit var activityBinding :ActivityDetailBinding
    private val detailViewModel : DetailViewModel by viewModel()
    companion object{
        const val EXTRA_INTENT = "extra_intent"
        const val TAG = "Detail Movie"
        const val Favotite_text = "Favorited"
        const val Unfavorited_text = "Unfavorited"
       
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityDetailBinding.inflate(layoutInflater)
        binding = activityBinding.detailContent
        setContentView(activityBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = TAG



        val data = intent.getParcelableExtra<EntityItem>(EXTRA_INTENT) as EntityItem
        showLoading(true)
        if (data != null){
            populateData(data)
            showLoading(false)
        }else{
            addErrorTxt(R.string.error.toString())
            showLoading(false)
        }


    }


    private fun populateData(entity: EntityItem){
        with(binding){
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/original${entity.posterPath}")
                .transform(RoundedCorners(20))
                .placeholder(R.drawable.ic_movie)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fitCenter()
                .into(imagePoster)
            Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/original${entity.backdropPath}")
                    .transform(RoundedCorners(20))
                    .placeholder(R.drawable.ic_movie)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fitCenter()
                    .into(backdropImage)
            textTitle.text = entity.title
            textGenre.text = entity.genre
            textDate.text = entity.releaseDate
            textDescription.text = entity.description
            ratingBar.numStars = 5
            ratingBar.stepSize = 0.5F
            ratingBar.rating = entity.rating!!.toFloat()/2
            ratingBar.isEnabled = false
            score.text = (entity.rating!!.toFloat()).toString()

            var statusFavorite = entity.isFavorite
            setStatusFavorite(statusFavorite)
            btnFav.setOnClickListener {
                statusFavorite = !statusFavorite
                setStatusFavorite(statusFavorite)
                if(statusFavorite){
                    Toast.makeText(this@DetailActivity, Favotite_text,Toast.LENGTH_SHORT).show()
                }else Toast.makeText(this@DetailActivity, Unfavorited_text,Toast.LENGTH_SHORT).show()
                detailViewModel.setFavoriteFilm(entity,statusFavorite)

            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.btnFav.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.btnFav.setImageResource(R.drawable.ic_favorite_border)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finishAfterTransition()
        return super.onSupportNavigateUp()
    }
    private fun showLoading(state:Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
            binding.ratingBar.visibility = View.GONE
            binding.cover.visibility = View.GONE
            binding.btnFav.visibility = View.GONE
            binding.rating.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.ratingBar.visibility = View.VISIBLE
            binding.cover.visibility = View.VISIBLE
            binding.btnFav.visibility = View.VISIBLE
            binding.rating.visibility = View.VISIBLE
        }
        
    }
    private fun addErrorTxt(message:String){
        binding.txtError.visibility = View.VISIBLE
        binding.txtError.text = message
    }


}