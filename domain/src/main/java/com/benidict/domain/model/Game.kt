package com.benidict.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val date: String,
    val team: Team = Team.empty,
    val score: Int,
    val period: Int,
    val postseason: Boolean,
    val season: Int,
    val status: String,
    val time: String,
    val visitorTeam: Team = Team.empty,
    val visitorScore: Int
): Parcelable {
    companion object {
        fun empty() = Game (
            id = 0,
            date = "",
            team = Team.empty,
            score = 0,
            period = 0,
            postseason = false,
            season = 0,
            status = "",
            time = "",
            visitorTeam = Team.empty,
            visitorScore = 0
        )
    }
}