package com.khasna.jetactors.ui.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khasna.jetactors.ui.component.HeaderProfile
import com.khasna.jetactors.ui.component.HomeAppBar
import com.khasna.jetactors.ui.theme.JetActorsTheme

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
){
    Scaffold(
        topBar = {
            HomeAppBar(
                actions = {
                    navigateUp()
                },
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            HeaderProfile()
            Spacer(modifier = Modifier.padding(24.dp))
            Text(
                text = "About me",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Hallo, i'm Khasna Ulya Mutiara from University of PGRI Semarang major Informatik",
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .alpha(0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    JetActorsTheme {
        AboutScreen {}
    }
}
