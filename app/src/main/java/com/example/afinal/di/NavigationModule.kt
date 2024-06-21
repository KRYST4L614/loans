package com.example.afinal.di

import com.example.afinal.feature.addresses.AddressesRouter
import com.example.afinal.feature.auth.AuthRouter
import com.example.afinal.feature.home.HomeRouter
import com.example.afinal.feature.onboarding.OnboardingRouter
import com.example.afinal.feature.special.SpecialRouter
import com.example.afinal.feature.support.SupportRouter
import com.example.afinal.navigation.AddressesRouterImpl
import com.example.afinal.navigation.AuthRouterImpl
import com.example.afinal.navigation.HomeRouterImpl
import com.example.afinal.navigation.LanguageRouterImpl
import com.example.afinal.navigation.OnboardingRouterImpl
import com.example.afinal.navigation.SpecialRouterImpl
import com.example.afinal.navigation.SupportRouterImpl
import com.exapmle.afinal.feature.language.LanguageRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NavigationModule {
    companion object {
        @Singleton
        @Provides
        fun provideCicerone() = Cicerone.create()

        @Provides
        @Singleton
        fun provideRouter(cicerone: Cicerone<Router>): Router {
            return cicerone.router
        }

        @Provides
        @Singleton
        fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder {
            return cicerone.getNavigatorHolder()
        }
    }

    @Binds
    fun bindAuthRouterImpl(impl: AuthRouterImpl): AuthRouter

    @Binds
    fun bindOnboardingRouterImpl(impl: OnboardingRouterImpl): OnboardingRouter

    @Binds
    fun bindHomeRouterImpl(impl: HomeRouterImpl): HomeRouter

    @Binds
    fun bindLanguageRouterImpl(impl: LanguageRouterImpl): LanguageRouter

    @Binds
    fun bindSpecialRouterImpl(impl: SpecialRouterImpl): SpecialRouter

    @Binds
    fun bindSupportRouterImpl(impl: SupportRouterImpl): SupportRouter

    @Binds
    fun bindAddressesRouterImpl(impl: AddressesRouterImpl): AddressesRouter

}