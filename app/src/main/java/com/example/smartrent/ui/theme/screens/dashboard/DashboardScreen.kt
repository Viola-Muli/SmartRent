package com.example.smartrent.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.smartrent.R
import com.example.smartrent.navigation.ROUT_HOME
import com.example.smartrent.navigation.ROUT_PAYMENTHISTORY
import com.example.smartrent.navigation.ROUT_PROFILE
import com.example.smartrent.navigation.ROUT_RENTPAYMENT
import com.example.smartrent.ui.theme.Frey
import com.example.smartrent.ui.theme.Lighterred

@Composable
fun DashBoardScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(painter = painterResource(id = R.drawable.signuplogin),
            contentDescription ="signup",
            modifier = Modifier
                .size(100.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text ="Pay your rent with ease",
            fontSize = 20.sp,
            )
        Spacer(modifier = Modifier.height(15.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            //Main Card
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(Lighterred)
            ){//Row1
                Row (modifier = Modifier.padding(20.dp)){
                    //Card1
                    Card(
                        modifier = Modifier
                            .clickable { navController.navigate(ROUT_HOME) }
                            .width(150.dp)
                            .height(160.dp),
                        elevation = CardDefaults.cardElevation(50.dp)

                        ) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center) {
                                Image(painter = painterResource(id = R.drawable.homeicon),
                                    contentDescription ="",
                                    modifier = Modifier
                                        .size(80.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text(text = "Home",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    //End of card1
                    Spacer(modifier = Modifier.width(25.dp))

                    //Card2
                    Card(modifier = Modifier
                        .clickable {navController.navigate(ROUT_PROFILE) }
                        .width(150.dp)
                        .height(160.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center) {
                                Image(painter = painterResource(id = R.drawable.profile),
                                    contentDescription ="Property",
                                    modifier = Modifier
                                        .size(80.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text(text = "Profile",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    //End of card2

                }
               //End of row1
                //Row2
                Row (modifier = Modifier.padding(20.dp)){
                    //Card3
                    Card(modifier = Modifier
                        .width(150.dp)
                        .height(160.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(modifier = Modifier.fillMaxWidth()
                                .clickable { navController.navigate(ROUT_RENTPAYMENT) }
                                ,
                                contentAlignment = Alignment.Center) {
                                Image(painter = painterResource(id = R.drawable.payrenticon),
                                    contentDescription ="",
                                    modifier = Modifier
                                        .size(80.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text(text = "Pay rent",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    //End of card3
                    Spacer(modifier = Modifier.width(25.dp))

                    //Card4
                    Card(modifier = Modifier
                        .width(150.dp)
                        .height(160.dp)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(modifier = Modifier.fillMaxWidth()
                                .clickable { navController.navigate(ROUT_PAYMENTHISTORY) }
                                ,
                                contentAlignment = Alignment.Center) {
                                Image(painter = painterResource(id = R.drawable.paymenthisticon),
                                    contentDescription ="",
                                    modifier = Modifier
                                        .size(80.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text(text = "Payment History",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    //End of card4





                }
                //End of row2
                //Row3
                Row (modifier = Modifier.padding(start = 90.dp)){
                    //Card5

                    //End of card5
                    Spacer(modifier = Modifier.width(25.dp))

                    //Card6
                    Card(modifier = Modifier
                        .width(150.dp)
                        .height(160.dp)

                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center) {
                                Image(painter = painterResource(id = R.drawable.settings),
                                    contentDescription ="",
                                    modifier = Modifier
                                        .size(80.dp)
                                )


                            }
                            Spacer(modifier = Modifier.height(25.dp))

                            Text(text = "Settings",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    //End of card6





                }
                //End of row3









            }
            //End of main card





        }










    }


}

@Composable
@Preview(showBackground = true)
fun DashBoardScreenPreview(){
    DashBoardScreen(rememberNavController())

}
