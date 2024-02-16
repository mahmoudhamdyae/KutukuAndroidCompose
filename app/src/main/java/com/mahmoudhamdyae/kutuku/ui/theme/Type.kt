package com.mahmoudhamdyae.kutuku.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mahmoudhamdyae.kutuku.R

val playFairSansFamily = FontFamily(
    Font(R.font.playfair__display_regular, FontWeight.Normal),
    Font(R.font.playfair_display_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.playfair_display_medium, FontWeight.Medium),
    Font(R.font.playfair_display_bold, FontWeight.Bold)
)

val cairoFamily = FontFamily(
    Font(R.font.cairo_light, FontWeight.Light),
    Font(R.font.cairo_regular, FontWeight.Normal),
    Font(R.font.cairo_regular, FontWeight.Medium),
    Font(R.font.cairo_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = playFairSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)