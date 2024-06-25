package com.iznan.domain.usecase

import com.iznan.domain.base.Resource
import com.iznan.domain.entity.News
import com.iznan.domain.irepository.INewsRepository
import com.iznan.domain.mapper.NewsListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarousellUseCase @Inject constructor(private val coinRepository: INewsRepository) {

    fun getNewsList(): Flow<Resource<List<News>?>> {
        return coinRepository.getNewsList().map { resource ->
            resource.mapResource {
                NewsListMapper().mapToListEntity(it)
            }
        }
    }

}