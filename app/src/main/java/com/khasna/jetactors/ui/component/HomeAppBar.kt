package com.khasna.jetactors.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khasna.jetactors.R



@Composable
fun HomeAppBar(
    actions: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        backgroundColor = Color.Gray,
        elevation = 0.dp,
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h1,
                fontSize = 30.sp,
                color = Color.Black
            )
        },
        actions = {
            IconButton(onClick = { actions() }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(
                        id = R.string.about_me,
                    ),
                    tint = MaterialTheme.colors.onSurface
                )
            }
        },
        modifier = modifier
    )
}