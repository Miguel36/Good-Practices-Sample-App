package com.skyfallen.goodpracticessampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.skyfallen.goodpracticessampleapp.ui.navigation.AppNavGraph
import com.skyfallen.goodpracticessampleapp.ui.theme.GoodPracticesSampleAppTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            mainViewModel.isSplashLoading
        }
        enableEdgeToEdge()
        setContent {
            GoodPracticesSampleAppTheme {
                AppNav()
            }
        }
    }

    @Composable
    private fun AppNav() {
        AppNavGraph()
    }
}