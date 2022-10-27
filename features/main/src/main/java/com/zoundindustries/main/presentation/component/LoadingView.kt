package com.zoundindustries.main.presentation.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.zoundindustries.theme.Black
import com.zoundindustries.theme.White
import com.zoundindustries.theme.circleSize
import com.zoundindustries.theme.strokeWidth

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = White,
            modifier = Modifier
                .width(circleSize)
                .height(circleSize),
            strokeWidth = strokeWidth
        )
    }
}
