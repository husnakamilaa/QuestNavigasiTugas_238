package com.example.navigasitugas.view

import android.graphics.fonts.Font
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasitugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    OnFormulirBtnClick:()-> Unit,
    OnBackToBeranda:()->Unit
) {
    val items = listOf(
        Pair(stringResource(R.string.nama_lengkap), "Aprilia Kurnianti"),
        Pair(stringResource(R.string.jenis_kelamin), "Perempuan"),
        Pair(stringResource(R.string.status), "Lajang"),
        Pair(stringResource(R.string.alamat), "Sleman")
    )
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.list), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(R.color.purple_200))
            )
        }) { isiRuang->
        Column(modifier = Modifier
            .background(Color(0xFFE8D3ED))
            .padding(isiRuang),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))) {
            items.forEach { item->
                    Card(modifier = Modifier
                        .padding(all=16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White))
                    {
                        Column {
                            Text(text = item.first.uppercase(),
                                fontSize = 16.sp)
                            Text(text = item.second,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Cursive,
                                fontSize = 20.sp
                            )
                        }

                    }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(modifier = Modifier
                .width(400.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.purple_200)
                ),
                onClick = OnBackToBeranda) {
                Text(text = stringResource(R.string.beranda))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(modifier = Modifier
                .width(400.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDCA2E6)
                ),
                onClick = OnFormulirBtnClick) {
                Text(text = stringResource(R.string.formulir))
            }
        }
    }
}