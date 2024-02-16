package com.mahmoudhamdyae.kutuku.auth.screen

import com.mahmoudhamdyae.kutuku.R
import com.mahmoudhamdyae.kutuku.core.navigation.NavigationDestination

object LoginDestination: NavigationDestination {
    override val route: String = "login"
    override val titleRes: Int = R.string.onboarding_screen_title
}

class LoginScreen {
}