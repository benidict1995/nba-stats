package com.benidict.network.base

import com.google.gson.annotations.SerializedName

data class BaseDTO<T>(
    @SerializedName("data") val data: T,
    @SerializedName("meta") val metaDTO: MetaDTO = MetaDTO.empty
)