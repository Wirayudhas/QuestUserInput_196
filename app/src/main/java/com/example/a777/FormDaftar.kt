package com.example.a777

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDaftar(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val status = listOf("Janda", "Lajang", "Duda")

    // Warna tema
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF7E57C2), Color(0xFF5C6BC0))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(top = dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF512DA8), Color(0xFF303F9F))
                    )
                )
        ) {
            Text(
                "Formulir Pendaftaran",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    ),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                tonalElevation = 4.dp,
                shadowElevation = 4.dp,
                color = Color(0xFFF9F9F9),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    SectionLabel("NAMA LENGKAP", Color(0xFF3F51B5))
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        placeholder = { Text("Tulis nama lengkap") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF5C6BC0),
                            unfocusedBorderColor = Color(0xFFB0BEC5)
                        )
                    )

                    SectionLabel("JENIS KELAMIN", Color(0xFF3F51B5))
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                .padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = { textJK = item },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF5E35B1)
                                )
                            )
                            Text(item, color = Color(0xFF424242))
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    SectionLabel("STATUS PERKAWINAN", Color(0xFF3F51B5))
                    status.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item }
                                )
                                .padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = { textStatus = item },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color(0xFF5E35B1)
                                )
                            )
                            Text(item, color = Color(0xFF424242))
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    SectionLabel("ALAMAT", Color(0xFF3F51B5))
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        placeholder = { Text("Alamat lengkap") },
                        minLines = 2,
                        maxLines = 4,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF5C6BC0),
                            unfocusedBorderColor = Color(0xFFB0BEC5)
                        )
                    )

                    Spacer(Modifier.height(20.dp))
                    Button(
                        onClick = { /* TODO: Action submit */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5E35B1)
                        )
                    ) {
                        Text(
                            stringResource(R.string.submit),
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF303F9F)),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 120.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
                ) {
                    Text(text = "Nama               : $nama", color = Color.White)
                    Text(text = "Jenis Kelamin      : $textJK", color = Color.White)
                    Text(text = "Status Perkawinan  : $textStatus", color = Color.White)
                    Text(text = "Alamat             : $alamat", color = Color.White)
                }
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String, color: Color) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        color = color,
        letterSpacing = 0.3.sp
    )
}
