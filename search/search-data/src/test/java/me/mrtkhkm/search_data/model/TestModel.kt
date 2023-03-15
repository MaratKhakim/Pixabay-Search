package me.mrtkhkm.search_data.model

import me.mrtkhkm.model.Hit

object TestModel {
    val firstHit = Hit(
        id = "2310212",
        tags = "fruit, lemon, art",
        webformatURL = "https://pixabay.com/get/g6498705d472f6ba77e99d925b50bb12a85ae5e321367c65a84d263fd475f96ebca88e8401af8a06294d2a60f81d184b1b2fe4f6a127e0c0fa89fbd7600265eaf_640.jpg",
        largeImageUrl = "https://pixabay.com/get/g25a04f9dc0805c22de375d39b55777fe0100705ff6716d83ece978b8a3c8388c73a79509c327af7f50ade4f45ca2853b2243638a37e74be95977390f69ecdaad_1280.jpg",
        views = 212123,
        downloads = 101433,
        likes = 990,
        comments = 173,
        user = "Yousz",
        userImageURL = "",
        imageUrl = "",
    )
    val secondHit = Hit(
        id = "2310213",
        tags = "fruit, lemon, art",
        webformatURL = "https://pixabay.com/get/g6498705d472f6ba77e99d925b50bb12a85ae5e321367c65a84d263fd475f96ebca88e8401af8a06294d2a60f81d184b1b2fe4f6a127e0c0fa89fbd7600265eaf_640.jpg",
        largeImageUrl = "https://pixabay.com/get/g25a04f9dc0805c22de375d39b55777fe0100705ff6716d83ece978b8a3c8388c73a79509c327af7f50ade4f45ca2853b2243638a37e74be95977390f69ecdaad_1280.jpg",
        views = 212123,
        downloads = 101433,
        likes = 990,
        comments = 173,
        user = "Yousz",
        userImageURL = "",
        imageUrl = "",
    )

    val hits = listOf(firstHit, secondHit)
    const val query = "fruits"
}