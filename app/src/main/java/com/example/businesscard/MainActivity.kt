package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    BusinessCard("SHAILESH SINGH","6201237193","@shaileshsingh_21","ss.forcoding@gmail.com")
                }
            }
        }
    }
}
@Composable
fun BusinessCard(name: String,mobile: String,social: String,eamil : String){
    Column(modifier = Modifier
        .background(Color(0xFF112e5b))
        .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Profile(name = name)
        ContactInfo(mobile = mobile, social = social, email = eamil)
    }
}
@Composable
fun Profile(name: String) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(modifier = Modifier.padding(30.dp),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = image, contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.15f)
        )
        Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 10.dp, bottom = 8.dp),
            color = Color.White
        )
        Text(text = "Android Developer Extraordinary", fontSize = 22.sp,
            fontWeight = FontWeight.Bold, color = Color(0xFF3ddc84)
            )
    }
}
@Composable
fun ContactInfo(mobile: String,social: String, email: String){
    Column(horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
        , modifier = Modifier.padding(bottom = 50.dp, top = 200.dp),

    ) {
        val call = painterResource(id = R.drawable.ic_baseline_call_24)
        val share= painterResource(id = R.drawable.ic_baseline_share_24)
        val gmail= painterResource(id = R.drawable.ic_baseline_email_24)
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = call, contentDescription = null,
                modifier = Modifier.padding(end = 16.dp))
            Text(text = mobile,
                fontSize = 24.sp,
                color = Color.White,
                )
        }
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = share, contentDescription = null,
                modifier = Modifier.padding(end = 16.dp))
            Text(text = social,
                fontSize = 24.sp,
                color = Color.White)
        }
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = gmail, contentDescription = null,
                modifier = Modifier.padding(end = 16.dp))
            Text(text = email,
                fontSize = 24.sp,
                color = Color.White)
        }

    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard("SHAILESH SINGH","6201237193","@shaileshsingh_21","ss.forcoding@gmail.com")
    }
}