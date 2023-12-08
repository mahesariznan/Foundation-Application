package com.iznan.domain.base

interface BaseMapper<Model, ResultEntity> {

    fun mapToEntity(model: Model): ResultEntity

}