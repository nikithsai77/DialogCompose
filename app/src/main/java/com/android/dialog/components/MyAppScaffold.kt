package com.android.dialog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@Composable
fun MyAppScaffold() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "Sample Dialog", style = MaterialTheme.typography.labelLarge)
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }) {
            var isDialogVisible by remember {
                mutableStateOf(false)
            }
            if (isDialogVisible) {
                SampleDialog(
                    onDismiss = { isDialogVisible = false },
                    onSuccess = { isDialogVisible = false },
                    dialogTitle = "Sample Dialog",
                    dialogText = "This is a Sample Dialog",
                    icon = Icons.Filled.Info
                )
            }
            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Button(modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(it), onClick = { isDialogVisible = true }) {
                    Text(text = "Click Here To Display The Dialog")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun `Mp-review`() {
    MyAppScaffold()
}
