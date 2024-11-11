package com.android.dialog.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun SampleDialog(onDismiss: () -> Unit, onSuccess: () -> Unit, dialogTitle: String, dialogText: String, icon: ImageVector) {
    AlertDialog(
        icon = {
            Icon(imageVector = icon, contentDescription = "Dialog Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = { onDismiss.invoke() },
        confirmButton = {
            TextButton(onClick = { onSuccess.invoke() }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss.invoke() }) {
                Text(text = "Dismiss")
            }
        }
    )
}