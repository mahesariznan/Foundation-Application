package com.iznan.foundation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.iznan.foundation.theme.ColorToken
import com.iznan.foundation.theme.Typography

/**
 * [TextAV]
 *
 * Composable Text to show basic (14sp) text.
 *
 * @param text text value
 * @param color text color
 * @param fontWeight text fontWeight Normal|Medium|Bold|Semibold
 * @param maxLines text maxLine with max value of integer line as default
 * @param overflow text overflow Visible|Clip|Ellipsis
 * @param textAlign text alignment
 */
@Composable
fun TextAV(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = ColorToken.TextIconBlackPrimary,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Visible,
    textAlign: TextAlign = TextAlign.Start,
    typography: TextStyle = Typography.normal
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        style = typography.copy(
            fontWeight = fontWeight
        ),
        maxLines = maxLines,
        overflow = overflow,
        textAlign = textAlign
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TextNormalPreview() {
    TextAV(text = "Hello world")
}
