package com.benidict.domain.state

sealed class ResponseState {
    object Loading: ResponseState()

    data class Success<out T>(
        val data: T?
    ): ResponseState()

    data class Failure(
        val e: Exception?
    ): ResponseState()
}