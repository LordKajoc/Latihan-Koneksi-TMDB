package com.lordkajoc.latihankoneksitmdb.model

import com.google.gson.annotations.SerializedName

data class GetAllFilmTMDB<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<GetAllFilmResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)