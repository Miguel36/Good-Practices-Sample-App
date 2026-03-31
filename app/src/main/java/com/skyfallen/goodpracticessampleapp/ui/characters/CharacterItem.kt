package com.skyfallen.goodpracticessampleapp.ui.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CharacterItem(character: String) {
    Card(
        modifier = Modifier.fillMaxWidth().height(390.dp),
        shape = RoundedCornerShape(5),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            Box(Modifier.height(240.dp).fillMaxWidth().background(Color.DarkGray))
            Column(Modifier.padding(8.dp)) {
                Text(text = "Name", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Specie", fontSize = 14.sp)
                Text(text = "Base Ki Desc", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Base Ki", fontSize = 14.sp)
                Spacer(Modifier.height(8.dp))
                Text(text = "Affiliation", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }

        }
    }
}