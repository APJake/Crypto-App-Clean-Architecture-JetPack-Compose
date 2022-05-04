package com.apjake.cryptoapp.domain.model

import com.apjake.cryptoapp.data.remote.dto.*

data class CoinDetail (
    val coinId: String,
    val name: String,
    val symbol: String,
    val description: String,
    val isActive: Boolean,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
        )