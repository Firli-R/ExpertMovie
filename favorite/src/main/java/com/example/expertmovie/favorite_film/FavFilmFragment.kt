package com.example.expertmovie.favorite_film

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.model.EntityItem
import com.example.expertmovie.detail.DetailActivity
import com.example.core.ui.ListAdapter
import com.example.expertmovie.R
import com.example.expertmovie.databinding.FragmentFilmBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavFilmFragment : Fragment() {
    private lateinit var binding: FragmentFilmBinding
    private val favViewModel : FavFilmViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentFilmBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = ListAdapter()
        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: EntityItem) {
                val intent  = Intent(activity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_INTENT,data)
                startActivity(intent)
            }

        })
        if (activity != null){
            favViewModel.getFilm().observe(viewLifecycleOwner,{
                if (it != null){
                    listAdapter.setData(it)
                    listAdapter.notifyDataSetChanged()
                    showLoading(false)
                }else{
                    showLoading(true)
                    addErrorTxt(getString(R.string.error))
                }

            })

            with(binding.recyclerview){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = listAdapter
            }
        }
    }
    private fun showLoading(state:Boolean){
        if(state){
            binding.progressBar2.visibility = View.VISIBLE
        }else{
            binding.progressBar2.visibility = View.GONE
            binding.txtError.visibility = View.GONE
        }

    }
    private fun addErrorTxt(message:String){
        binding.txtError.visibility = View.VISIBLE
        binding.txtError.text = message
    }
}