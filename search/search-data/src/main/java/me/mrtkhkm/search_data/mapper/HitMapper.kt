package me.mrtkhkm.search_data.mapper

import me.mrtkhkm.model.Hit
import me.mrtkhkm.search_data.local.entity.ImageEntity
import me.mrtkhkm.search_data.remote.dto.HitDto

fun HitDto.asEntity() = ImageEntity(
    id = id,
    imageUrl = imageUrl.orEmpty(),
    largeImageUrl = largeImageUrl.orEmpty(),
    webformatURL = webformatURL,
    user = user,
    likes = likes,
    downloads = downloads,
    tags = tags,
    comments = comments,
    views = views,
    userImageURL = userImageURL,
)

fun ImageEntity.asExternalModel() = Hit(
    id = id,
    imageUrl = imageUrl,
    largeImageUrl = largeImageUrl,
    webformatURL = webformatURL,
    user = user,
    likes = likes,
    downloads = downloads,
    tags = tags,
    comments = comments,
    views = views,
    userImageURL = userImageURL,
)