@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigasitugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasitugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Beranda(
    OnListDataBtnClick: () -> Unit
){
    Scaffold { isiRuang->
        val gambar = painterResource(id = R.drawable.pastry)
        Column (modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = stringResource(R.string.welkam),
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 40.sp,
                color = colorResource(R.color.purple_200)
            )
            Spacer(modifier = Modifier.height(height = 30.dp))
            Image(painter = gambar,
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(height = 30.dp))
            Text(text = stringResource(R.string.namaku),
                modifier = Modifier,
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                color = colorResource(R.color.purple_200),
                )
            Spacer(modifier = Modifier.height(height = 10.dp))
        }
    }
}