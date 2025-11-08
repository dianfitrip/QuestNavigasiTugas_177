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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.list_title),
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ){isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(0.9f)
                    .padding(vertical = dimensionResource(id = R.dimen.padding_small)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacer_medium))
            ) {
                items(listPesertaStatis) { peserta ->
                    PesertaCard(peserta = peserta)
                }
            }
        }
    }
}
