package com.mahmoudhamdyae.kutuku.onboarding.onboarding_presentation.screens

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.mahmoudhamdyae.kutuku.R
import com.mahmoudhamdyae.kutuku.assertCurrentRouteName
import com.mahmoudhamdyae.kutuku.auth.screen.LoginDestination
import com.mahmoudhamdyae.kutuku.core.navigation.MainScreen
import com.mahmoudhamdyae.kutuku.onNodeWithStringId
import com.mahmoudhamdyae.kutuku.onboarding.onboarding_data.models.OnboardingItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class OnboardingScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MainScreen(navController = navController)
        }
    }

    @Test
    fun clickSkipButton_navigateToLoginScreen() {
        navController.assertCurrentRouteName(OnboardingDestination.route)
        composeTestRule.onNodeWithStringId(R.string.skip).performClick()
        navController.assertCurrentRouteName(LoginDestination.route)
    }

    @Test
    fun clickNextButton_validateItems() {
        val items = OnboardingItem.getData()
        val nextButton = composeTestRule.onNodeWithStringId(R.string.next)
        val getStartedButton = composeTestRule.onNodeWithStringId(R.string.get_started)

        getStartedButton.assertDoesNotExist()
        nextButton.assertExists()
        composeTestRule.onNodeWithStringId(items[0].title).assertExists()
        composeTestRule.onNodeWithStringId(items[0].description).assertExists()
        nextButton.performClick()

        composeTestRule.onNodeWithStringId(items[1].title).assertExists()
//        composeTestRule.onNodeWithStringId(items[1].description).assertExists()
        nextButton.performClick()

        nextButton.assertDoesNotExist()
        getStartedButton.assertExists()
        composeTestRule.onNodeWithStringId(items[2].title).assertExists()
//        composeTestRule.onNodeWithStringId(items[2].description).assertExists()
        getStartedButton.performClick()

        navController.assertCurrentRouteName(LoginDestination.route)
    }
}