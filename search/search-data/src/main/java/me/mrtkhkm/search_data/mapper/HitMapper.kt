package me.mrtkhkm.search_data.mapper

import me.mrtkhkm.search_data.local.entity.ImageEntity
import me.mrtkhkm.search_data.remote.dto.HitDto
import me.mrtkhkm.search_domain.model.Hit

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
)