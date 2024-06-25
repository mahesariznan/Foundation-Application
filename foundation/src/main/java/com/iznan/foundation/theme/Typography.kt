package com.iznan.foundation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iznan.foundation.R

private val interW100 = Font(R.font.inter_thin, FontWeight.W100)
private val interW200 = Font(R.font.inter_extralight, FontWeight.W200)
private val interW300 = Font(R.font.inter_light, FontWeight.W300)
private val interW400 = Font(R.font.inter_regular, FontWeight.W400)
private val interW500 = Font(R.font.inter_medium, FontWeight.W500)
private val interW600 = Font(R.font.inter_semibold, FontWeight.W600)
private val interW700 = Font(R.font.inter_bold, FontWeight.W700)
private val interW800 = Font(R.font.inter_extrabold, FontWeight.W800)
private val interW900 = Font(R.font.inter_black, FontWeight.W900)

private val interFontFamily = FontFamily(
    fonts = listOf(
        interW100,
        interW200,
        interW300,
        interW400,
        interW500,
        interW600,
        interW700,
        interW800,
        interW900
    )
)

object Typography {
    val caption = TextStyle(
        fontFamily = interFontFamily,
        fontSize = 12.sp,
        lineHeight = 18.sp
    )

    val normal = TextStyle(
        fontFamily = interFontFamily,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )

    val subtitle = TextStyle(
        fontFamily = interFontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    val title = TextStyle(
        fontFamily = interFontFamily,
        fontSize = 18.sp,
        lineHeight = 27.sp
    )
}