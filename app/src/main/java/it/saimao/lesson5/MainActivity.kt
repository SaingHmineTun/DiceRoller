package it.saimao.lesson5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.saimao.lesson5.ui.theme.Lesson5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson5Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DiceRoller()
                }
            }
        }
    }
}

@Composable
fun DiceRoller() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            // Alignment.Center specifies that a component centers both vertically and horizontally.
            .wrapContentSize(Alignment.Center)

    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    var result by remember {
        mutableStateOf(1)
    }
    val imageResult = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        // The modifier argument ensures that the composables in the Column() function adhere to the constraints called on the modifier instance.
        modifier = modifier,
        // This ensures that the children within the column are centered on the device screen with respect to the width.
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(painter = painterResource(id = imageResult), contentDescription = "1")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = (1..6).random()
        }, Modifier.width(200.dp).height(50.dp)) {
            Text(text = stringResource(id = R.string.roll), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }

}