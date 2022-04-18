package com.eoghandev.randomsuperherogenerator.models.hero

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)