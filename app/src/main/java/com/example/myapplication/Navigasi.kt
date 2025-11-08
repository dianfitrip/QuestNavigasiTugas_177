package com.example.myapplication


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
        }
    }
}