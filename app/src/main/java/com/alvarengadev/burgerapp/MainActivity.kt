package com.alvarengadev.burgerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarengadev.burgerapp.ui.theme.BurguerAppTheme
import com.alvarengadev.burgerapp.ui.theme.darkGrey
import com.alvarengadev.burguerapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BurguerAppTheme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = { AppBar() }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.darkGrey
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                BurgerImageSection()

                BurgerDetailsSection()

                PriceSection()

                ButtonAddCart(
                    icon = painterResource(id = R.drawable.ic_basket),
                    text = "Add to cart",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = ""
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.darkGrey,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}

@Composable
fun BurgerImageSection() {
    Image(
        painter = painterResource(id = R.drawable.burger_details),
        contentDescription = "image description",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@Composable
fun BurgerDetailsSection() {
    Text(
        modifier = Modifier
            .padding(
                vertical = 16.dp,
                horizontal = 0.dp
            )
            .fillMaxWidth(),
        text = "Fresh Beef Burger with cheese",
        fontFamily = FontFamily(
            Font(R.font.gotham_medium)
        ),
        fontWeight = FontWeight(900),
        fontSize = 24.sp,
        color = Color.White
    )

    Text(
        modifier = Modifier
            .padding(
                vertical = 8.dp,
                horizontal = 0.dp
            )
            .fillMaxWidth(),
        text = "Burger with a huge pork cutlet, pickled cucumbers, blue onions, grilled vegetables (green beans, bell peppers, carrots), oyster dressing, black cuttlefish ink bun.",
        fontFamily = FontFamily(
            Font(R.font.gotham_light)
        ),
        fontWeight = FontWeight(700),
        fontSize = 14.sp,
        color = Color.White
    )
}

@Composable
fun PriceSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(
            40.dp,
            Alignment.Start
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Counter()
        TotalPrice()
    }
}

@Composable
fun Counter() {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .height(48.dp)
            .background(color = Color(0x0DFFFFFF), shape = RoundedCornerShape(size = 24.dp))
            .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(
            22.dp, Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconWithBackground(
            painter = painterResource(id = R.drawable.ic_plus)
        )
        Text(
            text = "1",
            color = Color.White,
            fontWeight = FontWeight(900),
            fontSize = 20.sp
        )
        IconWithBackground(
            painter = painterResource(id = R.drawable.ic_minus)
        )
    }
}


@Composable
fun IconWithBackground(
    painter: Painter,
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(
                color = Color(0xFF19191D),
                shape = RoundedCornerShape(size = 100.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = Color.White
        )
    }
}

@Composable
fun TotalPrice() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Total price",
            fontSize = 10.sp,
            fontFamily = FontFamily(
                Font(R.font.gotham_light)
            ),
            fontWeight = FontWeight(700),
            color = Color.White
        )
        Text(
            text = "$18.00",
            fontSize = 24.sp,
            fontFamily = FontFamily(
                Font(R.font.gotham_bold)
            ),
            color = Color.White
        )
    }
}

@Composable
fun ButtonAddCart(
    icon: Painter,
    text: String,
    modifier: Modifier = Modifier,
) {
    Button(
        colors = ButtonDefaults.buttonColors(contentColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { },
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFFE1D24A),
                            Color(0xFFC69223)
                        )
                    )
                )
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = icon,
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = text,
                    fontSize = 16.sp, fontFamily = FontFamily(
                        Font(R.font.gotham_bold)
                    ),
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BurguerAppTheme {
        MyApp()
    }
}
