package com.benidict.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    val totalPages: Int,
    val currentPage: Int,
    val nextPage: Int,
    val perPage: Int,
    val totalCount: Int
) : Parcelable {
    companion object {
        val empty = Meta(
            totalPages = 0,
            currentPage = 0,
            nextPage = 0,
            perPage = 0,
            totalCount = 0
        )
    }
}