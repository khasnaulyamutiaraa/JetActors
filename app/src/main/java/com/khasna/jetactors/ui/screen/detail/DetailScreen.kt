package com.khasna.jetactors.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.khasna.jetactors.ui.component.MyTopAppBar
import com.khasna.jetactors.repository.ActorsRepository
import com.khasna.jetactors.ui.theme.JetActorsTheme
import com.khasna.jetactors.utils.ViewModelFactory

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    idActors: String,
    navigateUp: () -> Unit,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            ActorsRepository(),
        ),
    ),
) {
    val actorsData by viewModel.getActorsData(idActors).collectAsState()

    Scaffold(
        topBar = {
            MyTopAppBar(
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
            AsyncImage(
                model = actorsData.photoUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            )
            Spacer(modifier = Modifier.padding(14.dp))
            Text(
                text = actorsData.name.uppercase(),
                style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Divider(color = MaterialTheme.colors.onBackground, thickness = 1.dp)
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = actorsData.description,
                lineHeight = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .alpha(0.7f)
            )
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }

}


@Preview
@Composable
fun DetailScreenPreview() {
    JetActorsTheme {
        DetailScreen(idActors = "01", navigateUp = { })
    }
}
