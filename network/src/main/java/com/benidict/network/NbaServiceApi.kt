package com.benidict.network

import com.benidict.network.base.BaseDTO
import com.benidict.network.model.TeamDTO
import retrofit2.http.GET

interface NbaServiceApi {
    @GET("v1/teams")
    suspend fun loadTeams(): BaseDTO<List<TeamDTO>>
}