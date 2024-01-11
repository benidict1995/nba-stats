package com.benidict.nba_stats.ext

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

@Composable
fun <T: Any> LazyPagingItems<T>.LoadPagingStateItem(
    loadingRefresh: @Composable () -> Unit,
    loadingAppend: @Composable () -> Unit,
    errorRefresh: (Throwable) -> Unit,
    errorAppend: (Throwable) -> Unit
) {
    val pagingItem = this
    pagingItem.apply {
        when {
            loadState.refresh is LoadState.Loading -> loadingRefresh()
            loadState.refresh is LoadState.Error -> errorRefresh((pagingItem.loadState.refresh as LoadState.Error).error)
            loadState.append is LoadState.NotLoading -> loadingAppend()
            loadState.append is LoadState.Error -> errorAppend((pagingItem.loadState.append as LoadState.Error).error)
        }
    }
}