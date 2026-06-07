package com.example.finanzasnexus.ui.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
private val Red = Color(0xFFFF4757)
private val Cyan = Color(0xFF35C8FF)
private val TextGray = Color(0xFF8D96A8)

data class Transaction(
    val title: String,
    val date: String,
    val amount: String,
    val isIncome: Boolean,
    val icon: String,
    val iconColor: Color
)

@Composable
fun HistoryScreen(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    var selectedFilter by remember { mutableStateOf("todo") }
    var conceptInput by remember { mutableStateOf("") }
    var amountInput by remember { mutableStateOf("") }

    val mockTransactions = listOf(
        Transaction("Quincena", "7 abr 2026", "+150,00 US$", true, "income", Green),
        Transaction("Ahorro automático (10%)", "7 abr 2026", "-15,00 US$", false, "check", Blue),
        Transaction("Internet", "7 abr 2026", "-20,00 US$", false, "arrow", Orange),
        Transaction("Aporte a meta: Televisión", "7 abr 2026", "-10,00 US$", false, "flag", Purple),
        Transaction("Uso de meta: Televisión", "7 abr 2026", "-10,00 US$", false, "cart", Purple),
        Transaction("Aporte a meta: Audífonos", "7 abr 2026", "-10,00 US$", false, "flag", Purple),
        Transaction("Retiro emergencia desde meta: Audífonos", "7 abr 2026", "+10,00 US$", true, "warning", Orange),
        Transaction("Aporte a meta: Audífonos", "7 abr 2026", "-10,00 US$", false, "flag", Purple),
    )

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
            // Título
            Text(
                text = "Historial",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Filtros
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FilterButton(
                    label = "Todo",
                    isSelected = selectedFilter == "todo",
                    onClick = { selectedFilter = "todo" }
                )
                FilterButton(
                    label = "Ingresos",
                    isSelected = selectedFilter == "ingresos",
                    onClick = { selectedFilter = "ingresos" }
                )
                FilterButton(
                    label = "Gastos",
                    isSelected = selectedFilter == "gastos",
                    onClick = { selectedFilter = "gastos" }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Sección Registrar egreso
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, TextGray, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = CardColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Registrar egreso",
                        color = TextGray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    // Input Concepto
                    OutlinedTextField(
                        value = conceptInput,
                        onValueChange = { conceptInput = it },
                        placeholder = { Text("Concepto (ej: transporte)", color = TextGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = TextGray,
                            focusedBorderColor = Cyan,
                            unfocusedTextColor = Color.White,
                            focusedTextColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Input Monto
                        OutlinedTextField(
                            value = amountInput,
                            onValueChange = { amountInput = it },
                            placeholder = { Text("Monto", color = TextGray) },
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = TextGray,
                                focusedBorderColor = Cyan,
                                unfocusedTextColor = Color.White,
                                focusedTextColor = Color.White
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )

                        // Botón Guardar egreso
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .height(50.dp)
                                .width(140.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Red),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Guardar egreso",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de acciones rápidas
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ActionButton(
                    label = "-5 gasto",
                    icon = Icons.Default.Remove,
                    color = Red,
                    modifier = Modifier.weight(1f)
                )
                ActionButton(
                    label = "+10 ahorro",
                    icon = Icons.Default.CheckCircle,
                    color = Blue,
                    modifier = Modifier.weight(1f)
                )
                ActionButton(
                    label = "-10 ahorro",
                    icon = Icons.AutoMirrored.Filled.ArrowBack,
                    color = Orange,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Lista de transacciones
            mockTransactions.forEach { transaction ->
                TransactionItem(transaction)
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun FilterButton(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(40.dp)
            .border(
                1.dp,
                if (isSelected) Color.Transparent else Color(0xFF2D3E50),
                RoundedCornerShape(20.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Cyan else Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = label,
            color = if (isSelected) Color.Black else Color(0xFF8D96A8),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ActionButton(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = modifier
            .height(50.dp)
            .border(1.dp, color, RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = label,
            color = color,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF2D3E50), RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Icon
                Icon(
                    imageVector = getTransactionIcon(transaction.icon),
                    contentDescription = null,
                    tint = transaction.iconColor,
                    modifier = Modifier.size(32.dp)
                )

                // Texto
                Column {
                    Text(
                        text = transaction.title,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = transaction.date,
                        color = TextGray,
                        fontSize = 12.sp
                    )
                }
            }

            // Monto
            Text(
                text = transaction.amount,
                color = if (transaction.isIncome) Green else Red,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun getTransactionIcon(iconType: String) = when (iconType) {
    "income" -> Icons.Default.ArrowDownward
    "check" -> Icons.Default.CheckCircle
    "arrow" -> Icons.Default.Info
    "flag" -> Icons.Default.Flag
    "cart" -> Icons.Default.ShoppingCart
    "warning" -> Icons.Default.Warning
    else -> Icons.Default.AttachMoney
}
