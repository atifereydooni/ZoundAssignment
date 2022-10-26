package com.zoundindustries.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zoundindustries.assignment.navigation.Navigation
import com.zoundindustries.theme.ZoundAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZoundAssignmentTheme {
                Navigation()
            }
        }
    }
}
