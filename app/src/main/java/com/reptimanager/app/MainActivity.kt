package com.reptimanager.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ReptiManagerApp()
            }
        }
    }
}

@Composable
fun ReptiManagerApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Text("🐾") },
                    label = { Text("Haiwan") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Text("⏰") },
                    label = { Text("Peringatan") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Text("💰") },
                    label = { Text("Kewangan") }
                )
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = { Text("🧬") },
                    label = { Text("Morph") }
                )
                NavigationBarItem(
                    selected = selectedTab == 4,
                    onClick = { selectedTab = 4 },
                    icon = { Text("🥚") },
                    label = { Text("Pembiakan") }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize()) {
            when (selectedTab) {
                0 -> AnimalsScreen()
                1 -> RemindersScreen()
                2 -> FinanceScreen()
                3 -> MorphScreen()
                4 -> BreedingScreen()
            }
        }
    }
}

@Composable
fun AnimalsScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("🐾 Senarai Haiwan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("✅ Leopard Gecko\n✅ Bearded Dragon\n✅ Ball Python\n✅ Ikan")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}) { Text("➕ Tambah Haiwan") }
    }
}

@Composable fun RemindersScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("⏰ Peringatan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("✅ Makan — ikut jadual spesies")
        Text("✅ Cuci sangkar — automatik")
        Text("✅ Timbang berat — rekod kemajuan")
    }
}

@Composable fun FinanceScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("💰 Kewangan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("✅ Rekod belanja & jualan")
        Text("✅ Kira untung/rugi")
    }
}

@Composable fun MorphScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("🧬 Kalkulator Morph", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Pilih induk jantan & betina → lihat kemungkinan anak!")
    }
}

@Composable fun BreedingScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("🥚 Pembiakan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("✅ Rekod pasangan, telur, inkubasi, anak")
    }
}
