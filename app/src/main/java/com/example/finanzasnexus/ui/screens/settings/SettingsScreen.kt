package com.example.finanzasnexus.ui.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finanzasnexus.ui.components.AppBottomBar

// Reutilizamos la misma paleta de colores del resto de la app
private val Background = Color(0xFF080D12)
private val CardColor = Color(0xFF141C29)
private val Green = Color(0xFF0FA572)
private val Blue = Color(0xFF1298D6)
private val Magenta = Color(0xFFC523D6)
private val Red = Color(0xFFE23A57)
private val LinkBlue = Color(0xFF35C8FF)
private val TextGray = Color(0xFF8D96A8)
private val TextSoft = Color(0xFFC2C9D6)
private val FieldBorder = Color(0xFF344156)

@Composable
fun SettingsScreen(
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
                text = "Ajustes",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            CurrencyCard()

            Spacer(modifier = Modifier.height(20.dp))

            AutoSavingCard()

            Spacer(modifier = Modifier.height(20.dp))

            NotificationsCard()

            Spacer(modifier = Modifier.height(20.dp))

            AutomationCard()

            Spacer(modifier = Modifier.height(20.dp))

            BalancesCard()

            Spacer(modifier = Modifier.height(20.dp))

            BackupCard()

            Spacer(modifier = Modifier.height(20.dp))

            DangerZoneCard()

            Spacer(modifier = Modifier.height(28.dp))

            FooterCredits()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// --------------------------------------------------------------------------
// MONEDA
// --------------------------------------------------------------------------
@Composable
fun CurrencyCard() {
    SettingsCard {
        SectionLabel("MONEDA")

        Spacer(modifier = Modifier.height(16.dp))

        ValueField("USD")

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Código ISO (USD, EUR, etc.)",
            color = TextGray,
            fontSize = 13.sp
        )
    }
}

// --------------------------------------------------------------------------
// AHORRO AUTOMÁTICO
// --------------------------------------------------------------------------
@Composable
fun AutoSavingCard() {
    SettingsCard {
        SectionLabel("AHORRO AUTOMÁTICO")

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Al registrar un ingreso, este porcentaje se aparta automáticamente.",
            color = TextSoft,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Slider(
            value = 0.24f,
            onValueChange = {},
            colors = SliderDefaults.colors(
                thumbColor = Green,
                activeTrackColor = Green,
                inactiveTrackColor = Color(0xFF1D2A3B)
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "24%",
                color = Green,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Si ingresas 125,00 US$, se apartan 30,00 US$",
                color = TextGray,
                fontSize = 13.sp
            )
        }
    }
}

// --------------------------------------------------------------------------
// NOTIFICACIONES
// --------------------------------------------------------------------------
@Composable
fun NotificationsCard() {
    SettingsCard {
        SectionLabel("NOTIFICACIONES")

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Te avisamos antes de cada vencimiento.",
            color = TextSoft,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Días antes",
                color = Color.White,
                fontSize = 17.sp,
                modifier = Modifier.width(150.dp)
            )
            NumberBox("2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Hora del aviso",
                color = Color.White,
                fontSize = 17.sp,
                modifier = Modifier.width(150.dp)
            )
            NumberBox("9")
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "hrs (0–23)",
                color = TextGray,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ToggleOption(
                text = "Solo in-app",
                selected = false,
                selectedColor = Magenta,
                modifier = Modifier.weight(1f)
            )
            ToggleOption(
                text = "In-app + local",
                selected = true,
                selectedColor = Magenta,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// --------------------------------------------------------------------------
// AUTOMATIZACIÓN
// --------------------------------------------------------------------------
@Composable
fun AutomationCard() {
    SettingsCard {
        SectionLabel("AUTOMATIZACIÓN")

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Modo de pago y reposición de ahorro.",
            color = TextSoft,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ToggleOption(
                text = "Pago manual",
                selected = true,
                selectedColor = Blue,
                modifier = Modifier.weight(1f)
            )
            ToggleOption(
                text = "Pago automático",
                selected = false,
                selectedColor = Blue,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ToggleOption(
                text = "Reposición manual",
                selected = true,
                selectedColor = Green,
                modifier = Modifier.weight(1f)
            )
            ToggleOption(
                text = "Reposición auto",
                selected = false,
                selectedColor = Green,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// --------------------------------------------------------------------------
// TUS SALDOS
// --------------------------------------------------------------------------
@Composable
fun BalancesCard() {
    SettingsCard {
        SectionLabel("TUS SALDOS")

        Spacer(modifier = Modifier.height(20.dp))

        BalanceRow("Disponible", "0,00 US$", Color.White)

        Spacer(modifier = Modifier.height(12.dp))

        BalanceRow("En ahorro", "102,00 US$", Green)
    }
}

@Composable
fun BalanceRow(label: String, value: String, valueColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = TextGray, fontSize = 17.sp)
        Text(value, color = valueColor, fontSize = 17.sp, fontWeight = FontWeight.Bold)
    }
}

// --------------------------------------------------------------------------
// RESPALDO
// --------------------------------------------------------------------------
@Composable
fun BackupCard() {
    SettingsCard {
        SectionLabel("RESPALDO")

        Spacer(modifier = Modifier.height(18.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Blue)
            ) {
                Icon(Icons.Default.Upload, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Exportar", fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, FieldBorder),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Icon(Icons.Default.Download, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Importar")
            }
        }
    }
}

// --------------------------------------------------------------------------
// ZONA PELIGROSA
// --------------------------------------------------------------------------
@Composable
fun DangerZoneCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF5A2230), RoundedCornerShape(24.dp))
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp)
    ) {
        Text(
            text = "ZONA PELIGROSA",
            color = Red,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Elimina todos los datos guardados y empieza de cero.",
            color = TextSoft,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Red)
        ) {
            Icon(Icons.Default.Delete, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Borrar todos los datos", fontWeight = FontWeight.Bold)
        }
    }
}

// --------------------------------------------------------------------------
// FOOTER
// --------------------------------------------------------------------------
@Composable
fun FooterCredits() {
    HorizontalDivider(color = Color(0xFF1D2A3B))

    Spacer(modifier = Modifier.height(20.dp))

    val credits = buildAnnotatedString {
        withStyle(SpanStyle(color = TextGray)) {
            append("Hecho por ")
        }
        withStyle(SpanStyle(color = Color.White, fontWeight = FontWeight.Bold)) {
            append("CrisjoSsj")
        }
        withStyle(SpanStyle(color = TextGray)) {
            append(" · ")
        }
        withStyle(SpanStyle(color = LinkBlue)) {
            append("Ssj Nexa Software")
        }
    }

    Text(
        text = credits,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 14.sp
    )
}

// --------------------------------------------------------------------------
// Helpers reutilizables dentro de la pantalla de Ajustes
// --------------------------------------------------------------------------

/** Contenedor base de cada sección, con el mismo estilo de tarjeta del resto de la app. */
@Composable
fun SettingsCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardColor, RoundedCornerShape(24.dp))
            .padding(24.dp),
        content = content
    )
}

@Composable
fun SectionLabel(text: String) {
    Text(
        text = text,
        color = TextGray,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp,
        fontSize = 13.sp
    )
}

/** Campo de texto "falso" (solo visual) con un valor escrito. */
@Composable
fun ValueField(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .border(1.dp, FieldBorder, RoundedCornerShape(16.dp))
            .background(Background, RoundedCornerShape(16.dp))
            .padding(horizontal = 22.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

/** Cajita pequeña para mostrar un número (días, hora). */
@Composable
fun NumberBox(text: String) {
    Box(
        modifier = Modifier
            .width(74.dp)
            .height(52.dp)
            .border(1.dp, FieldBorder, RoundedCornerShape(14.dp))
            .background(Background, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Botón tipo "toggle" para los pares de opciones (mismo patrón que PriorityButton de Metas). */
@Composable
fun ToggleOption(
    text: String,
    selected: Boolean,
    selectedColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(54.dp)
            .background(
                if (selected) selectedColor else Background,
                RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (selected) selectedColor else FieldBorder,
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else TextGray,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        currentRoute = "settings",
        onNavigate = {}
    )
}
