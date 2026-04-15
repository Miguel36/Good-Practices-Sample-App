package com.skyfallen.goodpracticessampleapp.ui.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skyfallen.goodpracticessampleapp.R


@Composable
fun CharactersScreen(charactersViewmodel: CharactersViewModel = viewModel()) {
    val uiState by charactersViewmodel.uiState.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            Image(
                modifier = Modifier.height(240.dp).fillMaxWidth(),
                contentDescription = null,
                painter = painterResource(R.drawable.header_dragon_ball),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(20.dp))

            when {
                uiState.isLoading -> {
                    Box(Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center)
                    {
                        CircularProgressIndicator()
                    }
                }
                uiState.error != null -> {
                    Box(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                        Text(text = "Something went wrong: ${uiState.error}", Modifier.fillMaxWidth())
                    }
                }
                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        if (uiState.characterList.isNotEmpty()) {
                            items(uiState.characterList) { item ->
                                CharacterItem(item)
                            }
                        }
                        else { item(span = { GridItemSpan(maxLineSpan) }) { Text(text = "Items not found") } }
                    }
                }
            }
        }
    }
}