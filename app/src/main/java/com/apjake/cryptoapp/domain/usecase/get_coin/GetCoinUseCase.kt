package com.apjake.cryptoapp.domain.usecase.get_coin

import com.apjake.cryptoapp.common.Resource
import com.apjake.cryptoapp.data.remote.dto.toCoinDetail
import com.apjake.cryptoapp.domain.model.CoinDetail
import com.apjake.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Unexpected error"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Check your internet connection"))
        }
    }
}