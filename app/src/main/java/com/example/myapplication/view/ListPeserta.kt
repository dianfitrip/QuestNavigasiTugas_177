package com.example.myapplication.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

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
            // Tombol Navigasi di bawah
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBerandaClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(id = R.string.btn_beranda))
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_medium)))
                Button(
                    onClick = onFormulirClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = stringResource(id = R.string.btn_formulir))
                }
            }
        }
    }
}

@Composable
fun PesertaCard(peserta: PesertaData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation_small)
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DataLabelValue(
                    label = stringResource(id = R.string.label_nama_lengkap),
                    value = peserta.nama,
                    modifier = Modifier.weight(1f)
                )
                DataLabelValue(
                    label = stringResource(id = R.string.label_jenis_kelamin),
                    value = peserta.jenisKelamin,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DataLabelValue(
                    label = stringResource(id = R.string.label_status),
                    value = peserta.statusPerkawinan,
                    modifier = Modifier.weight(1f)
                )
                DataLabelValue(
                    label = stringResource(id = R.string.label_alamat),
                    value = peserta.alamat,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun DataLabelValue(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = label,
            fontSize = dimensionResource(id = R.dimen.font_size_small_label).value.sp,
            color = colorResource(id = R.color.grey_label)
        )
        Text(
            text = value,
            fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
