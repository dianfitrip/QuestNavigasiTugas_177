package com.example.myapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

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

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xlarge)))

                Button(
                    onClick = onMasukClick,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(dimensionResource(id = R.dimen.button_height))
                ) {
                    Text(
                        text = stringResource(id = R.string.masuk),
                        fontSize = dimensionResource(id = R.dimen.font_size_button).value.sp
                    )
                }
            }
        }
    }
}
