package com.eoghandev.randomsuperherogenerator.models.comics

import com.google.gson.annotations.SerializedName

data class Data(
    val limit: String?,
    @SerializedName("results")
    val results: List<Comic>? = null

)
