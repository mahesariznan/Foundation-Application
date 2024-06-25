package com.iznan.carousell.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iznan.carousell.presentation.ui.section.TimeDelegate
import com.iznan.carousell.presentation.ui.section.TimeSectionDelegate
import com.iznan.carousell.presentation.viewmodel.CarousellViewModel
import com.iznan.foundation.theme.foundationComposeView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewsFragment : Fragment(), TimeSectionDelegate by TimeDelegate() {
    private val viewModel: CarousellViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return foundationComposeView {
            NewsScreen(viewModel) { it.getRelativeTimeSpanString() }
        }
    }
}

@Composable
fun NewsScreen(
    viewModel: CarousellViewModel,
    timeConverter: (Long) -> String
) {
    val news by viewModel.newsData.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getNewsList()
    }
    NewsContent(
        newsData = news,
        onSortByPopular = { viewModel.sortByPopular() },
        onSortByRecent = { viewModel.sortByRecent() },
        timeConverter = timeConverter
    )
}