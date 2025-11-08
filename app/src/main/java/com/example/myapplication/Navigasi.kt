package com.example.myapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.FormIsian
import com.example.myapplication.view.HalamanHome
import com.example.myapplication.view.ListPesertaScreen

enum class Navigasi {
    Home,
    Formulirku,
    ListPeserta
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold(modifier = Modifier.fillMaxSize()) { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            // 1. Halaman Home
            composable(route = Navigasi.Home.name) {
                HalamanHome(
                    onMasukClick = { navController.navigate(Navigasi.ListPeserta.name) }
                )
            }
            // 2. Halaman Formulir
            composable(route = Navigasi.Formulirku.name) {
                FormIsian(
                    // Perintah untuk kembali ke List
                    onBackClick = { navController.popBackStack() },
                    // Perintah untuk kembali ke Home
                    onBerandaClick = {
                        navController.popBackStack(Navigasi.Home.name, inclusive = false)
                    }
                )
            }
            // 3. Halaman List Peserta
            composable(route = Navigasi.ListPeserta.name) {
                ListPesertaScreen(
                    onBerandaClick = {
                        navController.popBackStack(Navigasi.Home.name, inclusive = false)
                    },
                    onFormulirClick = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}