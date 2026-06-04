package com.example.finanzasnexus.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
  text: String,
  color: Color,
  enabled: Boolean = true,
  onClick: () -> Unit = {}
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            disabledContainerColor = Color(0xFF252B38)
        )
    ){
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview(
    text: String = "PrimaryButton",
    color: Color = Color.Blue,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
){
    PrimaryButton(text, color, enabled, onClick)
}