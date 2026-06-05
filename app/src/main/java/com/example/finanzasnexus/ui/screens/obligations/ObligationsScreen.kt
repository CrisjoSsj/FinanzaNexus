package com.example.finanzasnexus.ui.screens.obligations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finanzasnexus.ui.components.AppBottomBar
import com.example.finanzasnexus.ui.components.PrimaryButton

// Reutilizamos tu paleta de colores exacta
private val Background = Color(0xFF080D12)
private val CardColor = Color(0xFF141C29)
private val Green = Color(0xFF0FA572)
private val Blue = Color(0xFF1298D6)
private val Yellow = Color(0xFFFFC84B)
private val TextGray = Color(0xFF8D96A8)

@Composable
fun ObligationsScreen(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Scaffold(
        containerColor = Background,
        bottomBar = {
            AppBottomBar(
                currentRoute = currentRoute,
                onNavigate = onNavigate
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            // Título de la pantalla
            Text(
                text = "Obligaciones",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Mantén tus pagos fijos al día.",
                color = TextGray,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Resumen total del mes
            TotalObligationsSummary()

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para registrar un nuevo gasto fijo
            PrimaryButton(
                text = "+ Nueva Obligación",
                color = Blue // Usamos azul para diferenciarlo de "Registrar Ingreso" que era verde
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Sección de pendientes
            Text(
                text = "PENDIENTES",
                color = Yellow,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Ejemplo de tarjeta pendiente
            ObligationItemCard(
                title = "Internet",
                dueDate = "Vence el Día 11",
                amount = "20,00 US$",
                isPaid = false
            )

            Spacer(modifier = Modifier.height(12.dp))

            ObligationItemCard(
                title = "Suscripción Música",
                dueDate = "Vence el Día 15",
                amount = "5,99 US$",
                isPaid = false
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Sección de completados
            Text(
                text = "PAGADOS ESTE MES",
                color = Green,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            ObligationItemCard(
                title = "Luz Eléctrica",
                dueDate = "Pagado el 02 de Julio",
                amount = "15,50 US$",
                isPaid = true
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun TotalObligationsSummary() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Text(
            text = "Total a pagar este mes",
            color = TextGray,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "41,49 US$",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            progress = { 0.37f }, // Progreso de lo pagado vs lo pendiente
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = Green,
            trackColor = Color(0xFF1D2A3B)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Has pagado 15,50 US$ de 41,49 US$",
            color = TextGray,
            fontSize = 13.sp
        )
    }
}

@Composable
fun ObligationItemCard(
    title: String,
    dueDate: String,
    amount: String,
    isPaid: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de estado
        Icon(
            imageVector = if (isPaid) Icons.Default.CheckCircle else Icons.Default.Schedule,
            contentDescription = null,
            tint = if (isPaid) Green else Yellow,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Textos
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = dueDate,
                color = TextGray,
                fontSize = 13.sp
            )
        }

        // Monto y acción
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = amount,
                color = if (isPaid) TextGray else Color.White, // Si está pagado, lo atenuamos
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            if (!isPaid) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Text("Pagar", fontSize = 13.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun ObligationsScreenPreview() {
    ObligationsScreen(
        currentRoute = "obligations",
        onNavigate = {}
    )
}