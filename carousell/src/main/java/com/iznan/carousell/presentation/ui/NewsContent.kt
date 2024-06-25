package com.iznan.carousell.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.iznan.domain.base.Resource
import com.iznan.domain.entity.News
import com.iznan.foundation.R
import com.iznan.foundation.theme.ColorToken
import com.iznan.foundation.theme.Space
import com.iznan.foundation.theme.Typography
import com.iznan.foundation.theme.cardPadding
import com.iznan.foundation.theme.largePadding
import com.iznan.foundation.theme.screenPadding
import com.iznan.foundation.theme.smallPadding
import com.iznan.foundation.ui.AspectRatio168
import com.iznan.foundation.ui.AsyncImageAV
import com.iznan.foundation.ui.FullScreenLoading
import com.iznan.foundation.ui.TextAV
import com.iznan.foundation.theme.Color as ThemeColor


@Composable
fun NewsContent(
    modifier: Modifier = Modifier,
    newsData: Resource<List<News>?>,
    onSortByRecent: () -> Unit,
    onSortByPopular: () -> Unit,
    timeConverter: (Long) -> String
) {
    val localContext = LocalContext.current
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarWithMenu(onSortByRecent, onSortByPopular)
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            when (newsData.status) {
                Resource.Status.SUCCESS -> {
                    LazyColumn(modifier = Modifier.padding(horizontal = smallPadding)) {
                        newsData.data?.let {
                            items(it) {
                                NewsCardView(data = it, timeConverter = timeConverter)
                            }
                        }
                    }
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(localContext, newsData.message, Toast.LENGTH_SHORT).show()
                }

                Resource.Status.LOADING -> {
                    FullScreenLoading()
                }
            }
        }
    }
}

@Composable
fun NewsCardView(data: News, timeConverter: (Long) -> String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorToken.BaseWhite)
            .padding(
                start = screenPadding,
                end = screenPadding,
                top = screenPadding,
                bottom = cardPadding
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(Space.x1, ColorToken.SurfacePrimaryBase2),
        shape = RoundedCornerShape(largePadding)
    ) {
        Column {
            AsyncImageAV(
                modifier = Modifier
                    .aspectRatio(AspectRatio168)
                    .fillMaxWidth(),
                model = data.bannerUrl,
                contentScale = ContentScale.Crop
            )
            TextAV(
                modifier = Modifier.padding(horizontal = largePadding, vertical = smallPadding),
                overflow = TextOverflow.Ellipsis,
                text = data.title,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
            TextAV(
                modifier = Modifier.padding(horizontal = largePadding),
                overflow = TextOverflow.Ellipsis,
                text = data.description,
                fontWeight = FontWeight.Normal,
                maxLines = 2
            )
            TextAV(
                modifier = Modifier.padding(horizontal = largePadding, vertical = smallPadding),
                text = timeConverter(data.timeCreated), fontWeight = FontWeight.Light,
                color = ColorToken.TextIconBlackTertiary, typography = Typography.caption,
                maxLines = 1
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(
    onSortByRecent: () -> Unit,
    onSortByPopular: () -> Unit
) {
    var expanded = remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ThemeColor.primary,
            titleContentColor = Color.White
        ),
        title = { Text(stringResource(id = R.string.title)) },
        actions = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White),
                onClick = { expanded.value = !expanded.value }) {
                Icon(Icons.Default.MoreVert, contentDescription = "menu")
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                DropdownMenuItem(text = { Text(stringResource(id = R.string.recent)) }, onClick = {
                    expanded.value = false
                    onSortByRecent.invoke()
                })
                DropdownMenuItem(text = { Text(stringResource(id = R.string.popular)) }, onClick = {
                    expanded.value = false
                    onSortByPopular.invoke()
                })
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun NewsContentPreview() {
    NewsContent(
        newsData = Resource.success(
            listOf(
                News("loremipsum", "loremipsum", "loremipsum", 1532853058, 1),
                News("loremipsum", "loremipsum", "loremipsum", 1532853058, 1),
                News("loremipsum", "loremipsum", "loremipsum", 1532853058, 1),
                News("loremipsum", "loremipsum", "loremipsum", 1532853058, 1)
            )
        ), onSortByRecent = {}, onSortByPopular = {}, timeConverter = { "" }
    )
}