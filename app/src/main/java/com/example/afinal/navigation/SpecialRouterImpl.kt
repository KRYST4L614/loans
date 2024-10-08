package com.example.afinal.navigation

import com.example.afinal.feature.addresses.getAddressesScreen
import com.example.afinal.feature.special.SpecialRouter
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SpecialRouterImpl @Inject constructor(private val router: Router) : SpecialRouter {
    override fun close() = router.exit()
    override fun openAddresses() {
        router.exit()
        router.navigateTo(getAddressesScreen())
    }
}