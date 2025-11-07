package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
                        }

                    }
            }
        }
    }
}