package com.example.smartrent.ui.theme.screens.settings

import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartrent.navigation.ROUT_DASHBOARD
import com.example.smartrent.ui.theme.Dark


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(
            title = { Text(text ="SmartRent", fontFamily = FontFamily.Cursive, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Dark),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUT_DASHBOARD) }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "", tint = Color.LightGray)

                }
            },


            )
        Text(
            text ="Unavailable",
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 150.dp)

        )



    }


}

@Composable
@Preview(showBackground = true)
fun SettingsScreenPreview(){
    SettingsScreen(rememberNavController())
}