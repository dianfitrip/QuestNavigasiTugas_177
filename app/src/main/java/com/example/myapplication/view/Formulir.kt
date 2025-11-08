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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun FormIsian(
    onBackClick: () -> Unit,
    onBerandaClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val strLaki = stringResource(id = R.string.jk_laki)
    val strPerempuan = stringResource(id = R.string.jk_perempuan)
    val strJanda = stringResource(id = R.string.status_janda)
    val strLajang = stringResource(id = R.string.status_lajang)
    val strDuda = stringResource(id = R.string.status_duda)

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.form_title),
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
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Card(
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = MaterialTheme.shapes.large,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.card_elevation)
                )
            ){
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
                    horizontalAlignment = Alignment.Start
                ){
                    // INPUT NAMA LENGKAP
                    Text(
                        text = stringResource(id = R.string.label_nama_lengkap),
                        fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                        color = colorResource(id = R.color.grey_label)
                    )
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        label = { Text(text = stringResource(id = R.string.placeholder_nama)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_large)))

                    // JENIS KELAMIN
                    Text(
                        text = stringResource(id = R.string.label_jenis_kelamin),
                        fontSize = dimensionResource(id = R.dimen.font_size_label).value.sp,
                        color = colorResource(id = R.color.grey_label)
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        // Radio Laki-laki (Kode ditulis langsung)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = jenisKelamin == strLaki,
                                onClick = { jenisKelamin = strLaki }
                            )
                            Text(text = strLaki)
                        }
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.spacer_medium)))
                        // Radio Perempuan (Kode ditulis langsung)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = jenisKelamin == strPerempuan,
                                onClick = { jenisKelamin = strPerempuan }
                            )
                            Text(text = strPerempuan)
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_large)))
                }
            }
        }
    }
}
