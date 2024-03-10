package com.iznan.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

fun Fragment.foundationComposeView(content: @Composable () -> Unit): ComposeView {
    return ComposeView(requireContext()).apply {
        setContent {
            FoundationTheme(content = content)
        }
    }
}

@Composable
fun FoundationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

private val DarkColorScheme = darkColorScheme(
    primary = Color.primary,
    secondary = Color.secondary
)

private val LightColorScheme = lightColorScheme(
    primary = DarkColor.primary,
    secondary = DarkColor.secondary
)