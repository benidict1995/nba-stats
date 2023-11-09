package com.benidict.network.model

import com.benidict.domain.model.Team
import com.google.gson.annotations.SerializedName

data class TeamDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("abbreviation") val abbreviation: String,
    @SerializedName("city") val city: String,
    @SerializedName("conference") val conference: String,
    @SerializedName("division") val division: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("name") val name: String
) {
    companion object {
        val empty = TeamDTO(
            id = 0,
            abbreviation = "",
            city = "",
            conference = "",
            division = "",
            fullName = "",
            name = ""
        )

        fun toDomain(teamDTO: TeamDTO): Team {
            return with(teamDTO) {
                Team(
                    id = id,
                    abbreviation = abbreviation,
                    city = city,
                    conference = conference,
                    division = division,
                    fullName = fullName,
                    name = name
                )
            }
        }

        fun List<TeamDTO>.toDomain() = this.map {
            with(it) {
                Team(
                    id = id,
                    abbreviation = abbreviation,
                    city = city,
                    conference = conference,
                    division = division,
                    fullName = fullName,
                    name = name
                )
            }
        }.toList()
    }
}