package com.example.smartrent.ui.theme.screens.rentpayment

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smartrent.R
import com.example.smartrent.ui.theme.Lighterred
import com.example.smartrent.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RentPaymentScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize()){
        var selected by remember { mutableIntStateOf(0) }
        Scaffold( bottomBar = {
            NavigationBar(
                containerColor = White
            ) {
                bottomNavItems.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = index == selected,
                        onClick = {
                            selected = index
                            navController.navigate(bottomNavItem.route)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bottomNavItem.badges != 0) {
                                        Badge {
                                            Text(text = bottomNavItem.badges.toString())
                                        }
                                    } else if (bottomNavItem.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(imageVector =
                                if (index == selected)
                                    bottomNavItem.selectedIcon
                                else
                                    bottomNavItem.unselectedIcon,
                                    contentDescription = bottomNavItem.title)
                            }

                        },
                        label = {
                            Text(text = bottomNavItem.title)
                        })
                }
            }
        },
            topBar = {
                TopAppBar(title = { Text(text = "SmartRent", fontFamily = FontFamily.Cursive, fontSize = 30.sp) },
                    colors= TopAppBarDefaults.mediumTopAppBarColors(Lighterred),
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "", tint = Color.LightGray)

                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "",
                                tint = Color.LightGray
                            )
                        }
                        val mContext = LocalContext.current

                        IconButton(onClick = {  val callIntent = Intent(Intent.ACTION_DIAL)
                            callIntent.data = "tel:0799684916".toUri()
                            mContext.startActivity(callIntent) }) {
                            Icon(imageVector = Icons.Default.Call, contentDescription = "", tint = Color.LightGray)


                        }

                    }

                )


            },



            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally


                    ) {
                    Spacer(modifier = Modifier.height(100.dp))

                    Image(painter = painterResource(id = R.drawable.rentpayment),
                        contentDescription ="signup",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "PAY RENT HERE",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center)
                    val mContext = LocalContext.current

                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 70.dp, end = 70.dp)
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(100.dp)


                    ) {
                        Text(
                            text = "STK(SimToolKit)"
                        )

                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                            smsIntent.data = "smsto:0799684916".toUri()
                            smsIntent.putExtra("sms_body", "Hello Viola,how was your day?")
                            mContext.startActivity(smsIntent)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 70.dp, end = 70.dp)
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(100.dp)
                    )
                    {
                        Text(text = "SMS")

                    }
                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = {
                            val shareIntent = Intent(Intent.ACTION_SEND)
                            shareIntent.type = "text/plain"
                            shareIntent.putExtra(
                                Intent.EXTRA_EMAIL,
                                arrayOf("bernicemumbua0@gmail.com")
                            )
                            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                            mContext.startActivity(shareIntent)


                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 70.dp, end = 70.dp)
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        shape = RoundedCornerShape(100.dp)


                    ) {
                        Text(
                            text = "E-MAIL"
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))




                }
            })
    }
}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Profile",
        route="profile",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=0
    ),

    BottomNavItem(
        title = "History",
        route="paymenthistory",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=0
    ),

    BottomNavItem(
        title = "Settings",
        route="settings",
        selectedIcon=Icons.Filled.Settings,
        unselectedIcon=Icons.Outlined.Settings,
        hasNews = true,
        badges=0


    ),
)



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)

@Composable
@Preview(showBackground = true)
fun RentPaymentScreenPreview(){
    RentPaymentScreen(rememberNavController())

}