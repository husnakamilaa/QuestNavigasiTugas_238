package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    Beranda,
    ListData,
    Formulir
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    Scaffold { isiRuang->
        NavHost(
            navController = NavController,
            startDestination = Navigasi.Beranda.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Beranda.name) {
                Beranda(
                    OnListDataBtnClick = {
                        navController.navigate(route = Navigasi.ListData.name)
                    }
                )
            }
            composable(route = Navigasi.ListData.name) {
                ListData(
                    OnFormulirBtnClick = {
                        navController.navigate(route = Navigasi.Formulir.name)
                    }
                    OnBackBerandaBtnClick = {backToBeranda(navController)}
                )
            }
            composable(route= Navigasi.Formulir.name) {
                Formulir(
                    onBackListDataBtnClick = {backToListData(navController)}
                )
            }
        }
    }
}

