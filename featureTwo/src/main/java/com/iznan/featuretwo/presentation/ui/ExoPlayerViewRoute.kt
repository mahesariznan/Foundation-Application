package com.iznan.featuretwo.presentation.ui

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.Player
import androidx.media3.ui.PlayerView
import com.iznan.domain.entity.VideoItem
import com.iznan.featuretwo.presentation.viewmodel.PageThreeViewModel

@Composable
fun ExoPlayerViewRoute(
    viewModel: PageThreeViewModel = viewModel()
) {
    val videoItems by viewModel.videoItems.collectAsState()
    val selectVideoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            it?.let(viewModel::addVideoUri)
        }
    )
    var lifecycle by remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    ExoplayerView(
        player = viewModel.player,
        selectVideoLauncher = selectVideoLauncher,
        videoItems = videoItems,
        onPlayVideo = {
            viewModel.playVideo(it)
        },
        onPauseVideo = {
            when (lifecycle) {
                Lifecycle.Event.ON_PAUSE -> {
                    it.onPause()
                    it.player?.pause()
                }

                Lifecycle.Event.ON_RESUME -> {
                    it.onResume()
                }

                else -> Unit
            }
        }
    )
}

@Composable
fun ExoplayerView(
    player: Player?,
    selectVideoLauncher: ManagedActivityResultLauncher<String, Uri?>?,
    videoItems: List<VideoItem>,
    onPlayVideo: (Uri) -> Unit,
    onPauseVideo: (PlayerView) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AndroidView(
            factory = {
                PlayerView(it).also {
                    it.player = player
                }
            },
            update = {
                onPauseVideo(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        IconButton(onClick = {
            selectVideoLauncher?.launch("video/mp4")
        }) {
            Icon(
                painter = painterResource(id = com.google.android.material.R.drawable.mtrl_ic_arrow_drop_up),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(videoItems) {
                Text(text = it.name, modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPlayVideo.invoke(it.contentUri) }
                    .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExopleyerPreview() {
    ExoplayerView(null, null, listOf(), {}, {})
}