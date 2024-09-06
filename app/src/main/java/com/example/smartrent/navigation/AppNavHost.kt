package com.example.smartrent.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realestate.ui.theme.screens.home.HomeScreen
import com.example.smartrent.ui.theme.ProfileScreen
import com.example.smartrent.ui.theme.screens.about.AboutScreen
import com.example.smartrent.ui.theme.screens.dashboard.DashBoardScreen
import com.example.smartrent.ui.theme.screens.login.LogInScreen
import com.example.smartrent.ui.theme.screens.rentpayment.RentPaymentScreen
import com.example.smartrent.ui.theme.screens.settings.SettingsScreen
import com.example.smartrent.ui.theme.screens.signup.SignupScreen
import com.example.smartrent.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ROUT_SIGNUP) {
          SignupScreen (navController = navController)
        }
        composable(ROUT_LOGIN) {
            LogInScreen(navController = navController)
        }
        composable(ROUT_RENTPAYMENT) {
            RentPaymentScreen(navController = navController)
        }
        composable(ROUT_PAYMENTHISTORY) {
            RentPaymentScreen(navController = navController)
        }
        composable(ROUT_DASHBOARD) {
            DashBoardScreen(navController = navController)
        }
        composable(ROUT_PROFILE) {
            ProfileScreen(navController = navController)
        }
        composable(ROUT_SETTINGS) {
            SettingsScreen(navController = navController)
        }

    }}