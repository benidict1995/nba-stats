package com.benidict.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: Int,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val fullName: String,
    val name: String
) : Parcelable {
    companion object {
        val empty = Team(
            id = 0,
            abbreviation = "",
            city = "",
            conference = "",
            division = "",
            fullName = "",
            name = ""
        )
    }
}