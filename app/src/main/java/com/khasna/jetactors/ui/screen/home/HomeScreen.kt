package com.khasna.jetactors.ui.screen.home

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khasna.jetactors.ui.component.ActorsItem
import com.khasna.jetactors.ui.component.HomeAppBar
import com.khasna.jetactors.repository.ActorsRepository
import com.khasna.jetactors.ui.theme.JetActorsTheme
import com.khasna.jetactors.utils.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(
            ActorsRepository(),
        ),
    ),
    navigateToAbout: () -> Unit,
    navigateToDetail: (String) -> Unit,
) {
    val actors by viewModel.actors.collectAsState()

    Scaffold(
        topBar = {
            HomeAppBar(
                actions = {
                    navigateToAbout()
                },
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(7.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            content = {
                items(actors, key = { it.id }) {
                    ActorsItem(
                        photoUrl = it.photoUrl,
                        id = it.id,
                        name = it.name,
                        description = it.description,
                        modifier = Modifier.clickable {
                            navigateToDetail(it.id)
                        },
                    )
                }
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenLightAppPreview() {
    JetActorsTheme {
        HomeScreen(navigateToAbout = {}, navigateToDetail = {})
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenDarkAppPreview() {
    JetActorsTheme {
        HomeScreen(navigateToAbout = {}, navigateToDetail = {})
    }
}