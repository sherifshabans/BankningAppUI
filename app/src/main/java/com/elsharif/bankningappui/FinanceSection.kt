package com.elsharif.bankningappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elsharif.bankningappui.data.Finance
import com.elsharif.bankningappui.ui.theme.BlueStart
import com.elsharif.bankningappui.ui.theme.GreenStart
import com.elsharif.bankningappui.ui.theme.OrangeStart
import com.elsharif.bankningappui.ui.theme.PurpleStart

val financeList = listOf(

    Finance(
        icon = Icons.Rounded.Wallet,
        name ="My\nWallet",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name ="My\nBusiness",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Analytics,
        name ="Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name ="My\nTransactions",
        background = GreenStart
    )

)

@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {

            items(financeList.size){ index->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(
    index:Int
) {
    val finance= financeList[index]
    var lastPaddingIndex=0.dp
    if(index== financeList.size-1){
        lastPaddingIndex=16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingIndex)) {


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )

            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

        }
    }
}
