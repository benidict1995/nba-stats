package com.benidict.network.base

import com.benidict.domain.model.Meta
import com.google.gson.annotations.SerializedName

data class MetaDTO(
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("next_page") val nextPage: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("totalCount") val totalCount: Int
) {
    companion object {
        val empty = MetaDTO(
            totalPages = 0,
            currentPage = 0,
            nextPage = 0,
            perPage = 0,
            totalCount = 0
        )

        fun toDomain(metaDTO: MetaDTO): Meta {
            return with(metaDTO) {
                Meta(
                    totalPages = totalPages,
                    currentPage = currentPage,
                    nextPage = nextPage,
                    perPage = perPage,
                    totalCount = totalCount
                )
            }
        }
    }
}