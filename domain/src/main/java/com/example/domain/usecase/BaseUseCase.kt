package com.example.domain.usecase

interface BaseUseCase<Model, Params> {
    suspend fun invoke(params: Model? = null): Params
}