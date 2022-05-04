package com.apjake.cryptoapp.domain.repository

import com.apjake.cryptoapp.data.remote.dto.CoinDetailDto
import com.apjake.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}