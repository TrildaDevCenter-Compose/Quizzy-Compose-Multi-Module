package com.canerture.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.canerture.ui.components.QuizAppLinearProgress
import com.canerture.ui.components.QuizAppText
import com.canerture.ui.theme.QuizAppTheme
import kotlinx.coroutines.delay

@Composable
internal fun AnimatedLinearProgress() {
    var progressValue by remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        while (progressValue < 100f) {
            progressValue = 0
            repeat(100) {
                progressValue += 1
                delay(15)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        QuizAppLinearProgress(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            thickness = 28.dp,
            value = progressValue
        )
        QuizAppText(
            text = "$progressValue%",
            style = QuizAppTheme.typography.subheading2,
            modifier = Modifier.padding(8.dp)
        )
    }
}