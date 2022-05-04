package com.apjake.cryptoapp.presentation.coin_list

import com.apjake.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val coinList: List<Coin> = emptyList()
)
