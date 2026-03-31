package com.skyfallen.goodpracticessampleapp.ui.characters

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CharactersScreen() {
    val items = listOf("Character1", "Character2", "Character3", "Character4")

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(text = "Dragon Ball Header", textAlign = TextAlign.Center)
            }

            items(items) { item ->
                CharacterItem(item)
            }
        }
    }
}