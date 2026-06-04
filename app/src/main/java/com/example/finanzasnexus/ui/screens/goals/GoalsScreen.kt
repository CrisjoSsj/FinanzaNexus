package com.example.finanzasnexus.ui.screens.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finanzasnexus.ui.components.AppBottomBar
import com.example.finanzasnexus.ui.components.PrimaryButton

private val Background = Color(0xFF080D12)
private val CardColor = Color(0xFF141C29)
private val Green = Color(0xFF0FA572)
private val Blue = Color(0xFF1298D6)
private val Yellow = Color(0xFFFFC84B)
private val Purple = Color(0xFFC523D6)
private val Orange = Color(0xFFE88700)
private val TextGray = Color(0xFF8D96A8)

@Composable
fun GoalsScreen(
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
            Text(
                text = "Metas de ahorro",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Prioriza tus compras y automatiza tus aportes.",
                color = TextGray,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            RepositionCard()

            Spacer(modifier = Modifier.height(28.dp))

            NewGoalCard()

            Spacer(modifier = Modifier.height(28.dp))

            GoalCard(
                title = "Televisión",
                amount = "105,00 US$",
                priority = "Prioridad Alta · active",
                objective = "Objetivo: 200,00 US$ (52.5%)",
                progress = 0.52f
            )

            Spacer(modifier = Modifier.height(20.dp))

            GoalCard(
                title = "Audifonos",
                amount = "0,00 US$",
                priority = "Prioridad Media · active",
                objective = "Objetivo: 30,00 US$ (0.0%)",
                progress = 0f
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun RepositionCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF4A271A), RoundedCornerShape(24.dp))
            .background(Color(0xFF120F10), RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Text(
            text = "REPOSICIÓN PENDIENTE",
            color = Yellow,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Debes reponer 15,00 US$ al ahorro.",
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(22.dp))

        PrimaryButton(
            text = "Reponer sugerido (0,00 US$)",
            color = Color.DarkGray,
            enabled = false
        )
    }
}

@Composable
fun NewGoalCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Text(
            text = "Nueva meta",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(18.dp))

        FakeInput("Ej: Laptop")

        Spacer(modifier = Modifier.height(14.dp))

        FakeInput("Monto objetivo")

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            PriorityButton("Alta", false, Modifier.weight(1f))
            PriorityButton("Media", true, Modifier.weight(1f))
            PriorityButton("Baja", false, Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(22.dp))

        PrimaryButton(
            text = "Crear meta",
            color = Green
        )
    }
}
@Composable
fun FakeInput(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .border(1.dp, Color(0xFF344156), RoundedCornerShape(16.dp))
            .background(Background, RoundedCornerShape(16.dp))
            .padding(horizontal = 22.dp),
        contentAlignment = androidx.compose.ui.Alignment.CenterStart
    ) {
        Text(
            text = text,
            color = Color(0xFF4D5668),
            fontSize = 20.sp
        )
    }
}

@Composable
fun PriorityButton(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(54.dp)
            .background(
                if (selected) Blue else Background,
                RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (selected) Blue else Color(0xFF344156),
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GoalCard(
    title: String,
    amount: String,
    priority: String,
    objective: String,
    progress: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(priority, color = TextGray, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(6.dp))

                Text(objective, color = TextGray, fontSize = 16.sp)
            }

            Text(
                text = amount,
                color = Green,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp),
            color = Green,
            trackColor = Color(0xFF1D2A3B)
        )

        Spacer(modifier = Modifier.height(20.dp))

        FakeInput("Monto para operar")

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            SmallActionButton("Aportar", Blue, Modifier.weight(1f))
            SmallActionButton("Compra", Purple, Modifier.weight(1f))
            SmallActionButton("Emergencia", Orange, Modifier.weight(1f))
        }
    }
}

@Composable
fun SmallActionButton(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = modifier.height(52.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}