package com.skyfallen.goodpracticessampleapp.ui.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.skyfallen.goodpracticessampleapp.model.Character

@Composable
fun CharacterItem(character: Character) {
    Card(
        modifier = Modifier.fillMaxWidth().height(390.dp),
        shape = RoundedCornerShape(5),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier.height(240.dp).fillMaxWidth().padding(top = 8.dp),
                contentDescription = "Image from character",
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .build()
            )
            Column(Modifier.background(Color.Black).fillMaxWidth().weight(1f).padding(8.dp)) {
                Text(text = character.name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = character.race, fontSize = 14.sp, color = Color.Yellow)
                Text(text = "Base Ki", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                Text(text = character.ki, fontSize = 14.sp, color = Color.Yellow)
                Spacer(Modifier.height(8.dp))
                Text(text = character.affiliation, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
            }
        }
    }
}