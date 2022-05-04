package com.apjake.cryptoapp.domain.usecase.get_coins

import com.apjake.cryptoapp.common.Resource
import com.apjake.cryptoapp.data.remote.dto.toCoin
import com.apjake.cryptoapp.domain.model.Coin
import com.apjake.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            // for network starts with other than 2
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"Unexpected error"))
        }catch (e: IOException){
            // mostly network error
            emit(Resource.Error<List<Coin>>("Check your internet connection"))
        }
    }
}