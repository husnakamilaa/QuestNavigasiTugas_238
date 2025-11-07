package com.example.navigasitugas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    OnBackToListData:()-> Unit
) {
    var textName by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textStatus by remember { mutableStateOf(value = "") }

    var name by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusPerkawinan: List<String> = listOf("Janda", "Lajang", "Duda")

    Box(
        modifier = Modifier
            .background(Color(0xFFE8D3ED))
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color(0xFFCD73E8)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Formulir Pendaftaran",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    OutlinedTextField(
                        value = textName,
                        onValueChange = { textName = it },
                        label = { Text("Nama Lengkap") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column {
                        Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                Text(text = item)
                            }
                        }
                    }

                    Column {
                        Text("Status Perkawinan", fontWeight = FontWeight.SemiBold)
                        statusPerkawinan.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                )
                                Text(text = item)
                            }
                        }
                    }

                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = { textAlamat = it },
                        label = { Text("Alamat") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = textName.isNotEmpty() && textAlamat.isNotEmpty(),
                        onClick = {
                            name = textName
                            jenis = textJK
                            alamat = textAlamat
                            status = textStatus
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF9B47E6)
                        )
                    ) {
                        Text(text = "Submit", color = Color.White)
                    }
                }
            }
        }
    }
}