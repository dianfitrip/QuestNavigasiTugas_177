package com.example.myapplication.view


@Composable
fun HalamanHome(
    onMasukClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Card(
            modifier = Modifier.fillMaxSize(0.9f),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.pink)
            ),
            shape = MaterialTheme.shapes.large
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = dimensionResource(id = R.dimen.padding_xlarge)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = stringResource(id = R.string.selamat_datang),
                    fontSize = dimensionResource(id = R.dimen.font_size_header).value.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.red)
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xlarge)))

                Image(
                    painter = painterResource(id = R.drawable.x),
                    contentDescription = stringResource(id = R.string.logo_content_desc),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.logo_size))
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xlarge)))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Dian Fitri Pradini",
                        fontSize = dimensionResource(id = R.dimen.font_size_body).value.sp,
                        color = colorResource(id = R.color.red)
                    )
                    Text(
                        text = "20230140177",
                        fontSize = dimensionResource(id = R.dimen.font_size_body).value.sp,
                        color = colorResource(id = R.color.red)
                    )
                }
            }
        }
    }
}
