package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ResponseFilm(

	@field:SerializedName("results")
	val results: List<ResultsItemFilm>
	)


