package com.example.finanzasnexus.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.finanzasnexus.ui.components.PrimaryButton
import com.example.finanzasnexus.ui.components.AppBottomBar

private val Background = Color(0xFF080D12)
private val CardColor = Color(0xFF141C29)
private val Green = Color(0xFF0FA572)
private val Blue = Color(0xFF1298D6)
private val Yellow = Color(0xFFFFC84B)
private val TextGray = Color(0xFF8D96A8)

@Composable
fun HomeScreen(
    currentRoute: String,
    onNavigate: (String) -> Unit
){
    Scaffold(
        containerColor = Background,
        bottomBar = { AppBottomBar(
            currentRoute = currentRoute,
            onNavigate = onNavigate
        ) }
    ){padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ){
            Text(
                text = "Saldo Disponible",
                color = TextGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "0,00 US$",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Shield,
                    contentDescription = null,
                    tint = Green
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "En ahorro 120,00 US$",
                    color = Green,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(34.dp))
            PrimaryButton(
                text = "+ Registrar Ingreso",
                color = Green,
            )
            Spacer(modifier = Modifier.height(28.dp))
            PendingCard()
            Spacer(modifier = Modifier.height(26.dp))
            SectionTitle("PROXIMOS PAGOS")
            Spacer(modifier = Modifier.height(14.dp))
            PaymentCard()
            Spacer(modifier = Modifier.height(28.dp))
            MonthSumaryCard()
            Spacer(modifier = Modifier.height(28.dp))
            ObligationStatusCard()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun PendingCard(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF4A271A),
                shape = RoundedCornerShape(24.dp)
            )
            .background(Color(0xFF120F10), RoundedCornerShape(24.dp))
            .padding(24.dp)
    ){
        Text(
            text = "REPOSICIÓN PENDIENTE",
            color = Yellow,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Debes reponer 15,00 US$ al ahorro",
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
fun SectionTitle(text: String){
    Text(
        text = text,
        color = Yellow,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp
    )
}

@Composable
fun PaymentCard(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF4A271A),
                shape = RoundedCornerShape(24.dp)
            )
            .background(Color(0xFF120F10), RoundedCornerShape(24.dp))
            .padding(22.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(modifier = Modifier.weight(1f)){
            Text(
                text = "Pago de Internet",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "10,00 US$ - Vence 2026-07-11",
                color = TextGray,
                fontSize = 13.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            shape = RoundedCornerShape(16.dp)
        ){
            Text("Pagar")
        }
    }
}

@Composable
fun MonthSumaryCard(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ){
        Text(
            text = "RESUMEN DEL MES",
            color = TextGray,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(26.dp))
        SumaryRow("Ingresado", "150,00 US$", Green)
        SumaryRow("Obligaciones Totales", "30,00 US$", Color.White)
        Divider(
            modifier = Modifier.padding(vertical = 18.dp),
            color = Color(0xFF253044)
        )
        SumaryRow("Pagado este mes", "20,00 US$", Color(0XFF35C8FF))
        SumaryRow("Pendiente este mes", "10,00 US$", Color.White)
    }
}

@Composable
fun SumaryRow(label: String, value: String, valueColor: Color ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(label, color= TextGray, fontSize = 17.sp)
        Text(value, color = valueColor, fontSize = 17.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ObligationStatusCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Text(
            text = "ESTADO DE OBLIGACIONES",
            color = TextGray,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Green)
            Spacer(modifier = Modifier.width(18.dp))
            Text("Internet", color = Color.White, fontSize = 21.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text("20,00 US$", color = TextGray, fontSize = 17.sp)
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Schedule, contentDescription = null, tint = Yellow)
            Spacer(modifier = Modifier.width(18.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text("Jdjsjs", color = Color.White, fontSize = 21.sp)
                Text("Día 7", color = TextGray, fontSize = 14.sp)
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Pagar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        currentRoute = "home",
        onNavigate = {}
    )
}