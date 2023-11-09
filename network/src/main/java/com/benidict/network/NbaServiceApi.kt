package com.benidict.network

import com.benidict.network.base.BaseDTO
import com.benidict.network.model.GameDTO
import com.benidict.network.model.TeamDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface NbaServiceApi {
    @GET("v1/teams")
    suspend fun loadTeams(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): BaseDTO<List<TeamDTO>>

    @GET("v1/games")
    suspend fun loadGames(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): BaseDTO<List<GameDTO>>
}