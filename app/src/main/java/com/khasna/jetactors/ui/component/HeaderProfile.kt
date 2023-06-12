package com.khasna.jetactors.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.khasna.jetactors.R



    @Composable
    fun HeaderProfile(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.header_about),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(minHeight = 350.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 80f, bottomStart = 80f)))
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.about_page),
                    contentDescription = "Photo",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Text(
                    text = "Khasna Ulya Mutiara".uppercase(),
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "mutiarakhasna03@gmail.com",
                    color = Color.LightGray
                    )
            }
        }
    }


