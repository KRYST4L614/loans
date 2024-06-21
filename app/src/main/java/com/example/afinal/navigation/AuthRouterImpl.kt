package com.example.afinal.navigation

import com.example.afinal.feature.auth.AuthRouter
import com.example.afinal.feature.onboarding.getOnboardingScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class AuthRouterImpl @Inject constructor(private val router: Router) :
    AuthRouter {
    override fun openOnboarding() {
        router.replaceScreen(getOnboardingScreen())
    }
}