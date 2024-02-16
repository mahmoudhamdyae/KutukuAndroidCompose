package com.mahmoudhamdyae.kutuku.onboarding.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahmoudhamdyae.kutuku.R
import com.mahmoudhamdyae.kutuku.auth.screen.LoginDestination
import com.mahmoudhamdyae.kutuku.core.navigation.NavigationDestination
import com.mahmoudhamdyae.kutuku.onboarding.composable.BottomSection
import com.mahmoudhamdyae.kutuku.onboarding.composable.OnboardingItem
import com.mahmoudhamdyae.kutuku.onboarding.composable.TopSection
import com.mahmoudhamdyae.kutuku.onboarding.models.OnboardingItem
import kotlinx.coroutines.launch

object OnboardingDestination: NavigationDestination {
    override val route: String = "on_boarding"
    override val titleRes: Int = R.string.onboarding_screen_title
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    openAndClear: (String) -> Unit,
) {
    val items = OnboardingItem.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState(
        pageCount = { OnboardingItem.getData().size }
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopSection { openAndClear(LoginDestination.route) }

        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->
            OnboardingItem(item = items[page])
        }

        BottomSection(size = items.size, index = pageState.currentPage) {
            if (pageState.currentPage + 1 < items.size) {
                scope.launch { pageState.animateScrollToPage(pageState.currentPage + 1) }
            } else {
                openAndClear(LoginDestination.route)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(openAndClear = { })
}