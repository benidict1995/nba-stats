package com.benidict.network

import com.benidict.network.base.BaseDTO
import com.benidict.network.model.GameDTO
import com.benidict.network.model.TeamDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface NbaServiceApi {
    @GET("v1/teams")
    suspend fun loadTeams(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): BaseDTO<List<TeamDTO>>

    @GET("v1/games")
    suspend fun loadGames(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): BaseDTO<List<GameDTO>>

    @GET("v1/games/{id]")
    suspend fun loadGameDetails(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): BaseDTO<GameDTO>
}