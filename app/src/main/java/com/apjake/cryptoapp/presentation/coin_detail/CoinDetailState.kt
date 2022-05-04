package com.apjake.cryptoapp.presentation.coin_detail

import com.apjake.cryptoapp.domain.model.Coin
import com.apjake.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val coin: CoinDetail? = null
)
