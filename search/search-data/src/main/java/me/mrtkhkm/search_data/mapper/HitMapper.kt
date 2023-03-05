package me.mrtkhkm.search_data.mapper

import me.mrtkhkm.search_data.remote.dto.HitDto
import me.mrtkhkm.search_domain.model.Hit

fun HitDto.toHit(): Hit {
    return Hit(
        id = this.id,
        imageUrl = this.imageUrl.orEmpty(),
        largeImageUrl = this.largeImageUrl.orEmpty(),
        user = this.user,
        likes = this.likes,
        downloads = this.downloads,
        tags = this.tags,
        comments = this.comments,
        views = this.views
    )
}