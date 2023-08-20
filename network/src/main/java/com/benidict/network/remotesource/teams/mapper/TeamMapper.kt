package com.benidict.network.remotesource.teams.mapper

import com.benidict.domain.model.Team
import com.benidict.network.model.TeamDTO

fun List<TeamDTO>.mapRemoteToTeamDomain() = this.map {
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