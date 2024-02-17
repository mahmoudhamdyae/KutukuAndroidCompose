package com.mahmoudhamdyae.kutuku.onboarding.onboarding_presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoudhamdyae.kutuku.ui.theme.playFairSansFamily

@Composable
fun TopSection(onSkipClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Skip Button
        TextButton(
            onClick = onSkipClick,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(
                text = "Skip",
                color = MaterialTheme.colorScheme.primary,
                fontFamily = playFairSansFamily,
                )
        }
    }
}