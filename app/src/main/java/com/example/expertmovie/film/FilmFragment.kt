package com.example.expertmovie.film

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expertmovie.R
import com.example.core.data.Resource
import com.example.core.domain.model.EntityItem
import com.example.expertmovie.databinding.FragmentFilmBinding
import com.example.expertmovie.detail.DetailActivity
import com.example.core.ui.ListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class FilmFragment: Fragment() {
    private lateinit var binding: FragmentFilmBinding
    private val filmViewModel : FilmViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = ListAdapter()
        listAdapter.setOnItemClickCallback(object : ListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: EntityItem) {
                val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_INTENT,data)
                startActivity(intent)
            }

        })
        showLoading(true)

        if (activity != null){
            filmViewModel.getFilm().observe(viewLifecycleOwner,{
                if (it != null){
                    when(it){
                        is Resource.Success ->{
                            listAdapter.clearData()
                            listAdapter.setData(it.data!!)
                            listAdapter.notifyDataSetChanged()
                            showLoading(false)
                        }
                    }
                }else{
                    listAdapter.clearData()
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
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
        
    }
    private fun addErrorTxt(message:String){
        binding.txtError.visibility = View.VISIBLE
        binding.txtError.text = message
    }
}