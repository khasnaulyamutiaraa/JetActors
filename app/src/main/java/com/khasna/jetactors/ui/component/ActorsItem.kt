package com.khasna.jetactors.ui.component



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.khasna.jetactors.ui.theme.JetActorsTheme

@Composable
fun ActorsItem(
    photoUrl: String,
    id: String,
    name: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(160.dp)
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = id, fontSize = 120.sp, fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .alpha(0.2f)
                        .offset(y = (-17).dp),
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = name.uppercase(),
                        style = MaterialTheme.typography.h2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = description,
                        fontSize = 14.sp,
                        maxLines = 3,
                        lineHeight = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(6.dp))
        Divider(color = MaterialTheme.colors.onBackground, thickness = 0.5.dp)
    }
}
    @Preview(showBackground = true)
    @Composable
    fun ActorsListItemPreview() {
        JetActorsTheme() {
            ActorsItem("", "01", "Cha Eun Woo", "cha eun wo")
        }
    }

