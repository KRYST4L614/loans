package com.example.afinal.navigation

import androidx.fragment.app.Fragment
import com.example.afinal.feature.auth.getAuthScreen
import com.example.afinal.feature.home.HomeRouter
import com.example.afinal.feature.home.ui.HomePageFragment
import com.example.afinal.feature.home.ui.MenuPageFragment
import com.example.afinal.feature.onboarding.getOnboardingScreen
import com.example.afinal.feature.special.getSpecialScreen
import com.example.afinal.feature.support.getSupportScreen
import com.exapmle.afinal.feature.language.getLanguageScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class HomeRouterImpl @Inject constructor(private val router: Router) : HomeRouter {
    override fun getMenuPageFragment(): Fragment = MenuPageFragment.newInstance()

    override fun getHomePageFragment(): Fragment = HomePageFragment.newInstance()

    override fun openOnboarding() = router.navigateTo(getOnboardingScreen())

    override fun openSupport() = router.navigateTo(getSupportScreen())

    override fun openAuth() = router.navigateTo(getAuthScreen())

    override fun openLanguage() =
        router.navigateTo(getLanguageScreen())

    override fun openSpecial() = router.navigateTo(getSpecialScreen())
}