package com.example.pratica_estado_simonlucenadecastro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pratica_estado_simonlucenadecastro.repositorio.Galeria
import com.example.pratica_estado_simonlucenadecastro.repositorio.Repositorio
import com.example.pratica_estado_simonlucenadecastro.ui.theme.Pratica_EstadoSimonLucenaDeCastroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Tela()
            }
        }
    }
}

@Composable
fun Tela() {
    var repositorio by remember {
        mutableIntStateOf(0)
    }

    // Criar uma instância de Galeria
    val galeria = Galeria()

    // Adicionar algumas imagens à galeria
    galeria.addImagem(Repositorio(0, "kelly_pool", "“Kelly Pool”", "Um grupo de seis cães se diverte ao redor de uma mesa de bilhar jogando Kelly Pool. Os outros cinco cães estão entusiasticamente importunando o jogador, na tentativa de melhorar sua própria posição.\nÉ interessante notar que Coolidge escolheu colocar os cães envolvidos em um jogo conhecido por apostas."))
    galeria.addImagem(Repositorio(1, "ten_miles_to_a_garage", "“Ten Miles To A Garage”", "Uma família de cães está a caminho de um piquenique de verão (talvez comemorando o dia 4 de julho) quando enfrenta problemas com o carro em um trecho solitário de uma estrada rural. Eles provavelmente estão na zona rural de Nova York, pois esse é o estado da placa do carro. Os filhotes brincam no carro usando bonés e carregando cestas de comida, enquanto a maioria dos cães mais velhos tenta consertar o automóvel. Porém, normalmente, apenas um cachorro rastejou para baixo do carro e está realmente trabalhando com ferramentas, enquanto outros três ficam sentados de braços cruzados. Um deles está até deitado debaixo do carro, relaxando à sua sombra. Todos os cães adultos também aproveitaram a parada não programada para fumar um cigarro."))


    val arquivo = galeria.getArquivo(repositorio)
    val titulo = galeria.getTitulo(repositorio)
    val descricao = galeria.getDescricao(repositorio)

    // Mapeia o título para o ID do recurso correspondente
    val resourceId = when (arquivo) {
        "kelly_pool" -> R.drawable.kelly_pool
        "ten_miles_to_a_garage" -> R.drawable.ten_miles_to_a_garage
        else -> R.drawable.kelly_pool// R.drawable.kelly_pool // Um recurso de imagem padrão para quando não há correspondência
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier
                .fillMaxWidth()
                .height(350.dp)
            ) {
                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = "Example Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$titulo",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "$descricao",
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(PaddingValues(top = 8.dp))
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 20.dp))
        ) {
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    if (repositorio>0)
                        repositorio--
                }) {
                    Text(text = "Previous")
                }
            }
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    if (repositorio<galeria.getTamanhoRepositorio())
                        repositorio++
                }) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pratica_EstadoSimonLucenaDeCastroTheme {
        Tela()
    }
}