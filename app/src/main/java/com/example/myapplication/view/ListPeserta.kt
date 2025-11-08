package com.example.myapplication.view



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
){
    val listPesertaStatis = listOf(
        PesertaData("Cecil", "Perempuan", "Lajang", "Sleman"),
        PesertaData("biyy", "laki-laki", "Duda", "Bantul")
    )
}
