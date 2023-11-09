package com.benidict.network.model

import com.benidict.domain.model.Game
import com.benidict.domain.model.Team
import com.google.gson.annotations.SerializedName

data class GameDTO (
    @SerializedName("id") val id: Int,
    @SerializedName("date") val date: String,
    @SerializedName("home_team") val teamsDTO: TeamDTO = TeamDTO.empty,
    @SerializedName("home_team_score") val score: Int,
    @SerializedName("period") val period: Int,
    @SerializedName("postseason") val postseason: Boolean,
    @SerializedName("season") val season: Int,
    @SerializedName("status") val status: String,
    @SerializedName("time") val time: String,
    @SerializedName("visitor_team") val visitorTeam: TeamDTO = TeamDTO.empty,
    @SerializedName("visitor_team_score") val visitorScore: Int
) {
    companion object {
        val empty = GameDTO(
            id = 0,
            date = "",
            teamsDTO = TeamDTO.empty,
            score = 0,
            period = 0,
            postseason = false,
            season = 0,
            status = "",
            time = "",
            visitorTeam = TeamDTO.empty,
            visitorScore = 0
        )

        fun List<GameDTO>.toDomain() = this.map {
            with(it) {
                Game(
                    id = id,
                    date = date,
                    team = TeamDTO.toDomain(teamsDTO),
                    score = score,
                    period = period,
                    postseason = postseason,
                    season = season,
                    status = status,
                    time = time,
                    visitorTeam = TeamDTO.toDomain(visitorTeam),
                    visitorScore = visitorScore
                )
            }
        }
    }
}