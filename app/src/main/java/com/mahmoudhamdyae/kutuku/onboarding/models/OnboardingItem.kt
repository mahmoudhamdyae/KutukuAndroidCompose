package com.mahmoudhamdyae.kutuku.onboarding.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mahmoudhamdyae.kutuku.R

class OnboardingItem(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    companion object{
        fun getData(): List<OnboardingItem>{
            return listOf(
                OnboardingItem(R.drawable.on_boarding_image_1, R.string.on_boarding_title_1, R.string.on_boarding_text_1),
                OnboardingItem(R.drawable.on_boarding_image_2, R.string.on_boarding_title_2, R.string.on_boarding_text_2),
                OnboardingItem(R.drawable.on_boarding_image_3, R.string.on_boarding_title_3, R.string.on_boarding_text_3)
            )
        }
    }
}