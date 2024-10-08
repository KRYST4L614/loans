package com.example.afinal.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afinal.feature.acceptloan.presentation.AcceptLoanViewModel
import com.example.afinal.feature.addresses.presentation.AddressesViewModel
import com.example.afinal.feature.auth.presentation.AuthViewModel
import com.example.afinal.feature.home.presentation.HomeViewModel
import com.example.afinal.feature.homepage.presentation.HomePageViewModel
import com.example.afinal.feature.loandetails.presentation.LoanDetailsViewModel
import com.example.afinal.feature.menupage.presentation.MenuPageViewModel
import com.example.afinal.feature.myloanspage.presentation.MyLoansPageViewModel
import com.example.afinal.feature.onboarding.presentation.OnboardingViewModel
import com.example.afinal.feature.rejectloan.presentation.RejectLoanViewModel
import com.example.afinal.feature.requestloan.presentation.RequestLoanViewModel
import com.example.afinal.feature.special.presentation.SpecialViewModel
import com.example.afinal.feature.splash.presentation.SplashViewModel
import com.example.afinal.feature.support.presentation.SupportViewModel
import com.exapmle.afinal.feature.language.presentation.LanguageViewModel
import com.exapmle.shared.viewModelFactory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(OnboardingViewModel::class)
    fun bindOnboardingViewModel(viewModel: OnboardingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LanguageViewModel::class)
    fun bindLanguageViewModel(viewModel: LanguageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SpecialViewModel::class)
    fun bindSpecialViewModel(viewModel: SpecialViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SupportViewModel::class)
    fun bindSupportViewModel(viewModel: SupportViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddressesViewModel::class)
    fun bindAddressesViewModel(viewModel: AddressesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomePageViewModel::class)
    fun bindHomePageViewModel(viewModel: HomePageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuPageViewModel::class)
    fun bindMenuPageViewModel(viewModel: MenuPageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyLoansPageViewModel::class)
    fun bindMyLoansPageViewModel(viewModel: MyLoansPageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoanDetailsViewModel::class)
    fun bindLoanDetailsViewModel(viewModel: LoanDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestLoanViewModel::class)
    fun bindRequestLoanViewModel(viewModel: RequestLoanViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RejectLoanViewModel::class)
    fun bindRejectLoanViewModel(viewModel: RejectLoanViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AcceptLoanViewModel::class)
    fun bindAcceptLoanViewModel(viewModel: AcceptLoanViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}