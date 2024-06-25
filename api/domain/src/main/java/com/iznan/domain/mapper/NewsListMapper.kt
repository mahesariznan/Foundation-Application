package com.iznan.domain.mapper

import com.iznan.domain.base.BaseMapper
import com.iznan.domain.entity.News
import com.iznan.model.responsedata.NewsResponseData

class NewsListMapper : BaseMapper<NewsResponseData, News> {

    override fun mapToEntity(model: NewsResponseData): News {
        return News(
            title = model.title,
            description = model.description,
            bannerUrl = model.banner_url,
            timeCreated = model.time_created,
            rank = model.rank
        )
    }

    fun mapToListEntity(models: List<NewsResponseData>?): List<News>? {
        return if (models != null) {
            val result = mutableListOf<News>()
            models.forEach {
                result.add(mapToEntity(it))
            }
            result
        } else null
    }

}