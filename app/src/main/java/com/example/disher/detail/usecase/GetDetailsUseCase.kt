package com.example.disher.detail.usecase

import com.example.disher.detail.model.DetailResponse
import com.example.disher.detail.repository.IDetailRepository
import javax.inject.Inject

interface IGetDetailsUseCase {
    suspend operator fun invoke(id: String): DetailResponse
}

class GetDetailsUseCase @Inject constructor(
    val repo: IDetailRepository
) : IGetDetailsUseCase{

    override suspend fun invoke(id: String): DetailResponse {
        return repo.getDetailsOfDish(id)
    }
}