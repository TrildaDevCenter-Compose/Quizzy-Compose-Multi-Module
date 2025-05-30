package com.canerture.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.canerture.feature.splash.ui.R
import com.canerture.ui.component.AnimatedLinearProgress
import com.canerture.ui.components.QuizAppText
import com.canerture.ui.extensions.boldBorder
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.ui.theme.QuizAppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
internal fun SplashScreen(
    uiEffect: Flow<SplashContract.UiEffect>,
    onNavigateWelcome: () -> Unit,
    onNavigateHome: () -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            SplashContract.UiEffect.NavigateWelcome -> onNavigateWelcome()
            SplashContract.UiEffect.NavigateHome -> onNavigateHome()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(QuizAppTheme.colors.background),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            imageVector = QuizAppTheme.icons.starPattern,
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(48.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier
                    .size(144.dp)
                    .clip(CircleShape)
                    .boldBorder(100),
                imageVector = QuizAppTheme.icons.logo,
                tint = Color.Unspecified,
                contentDescription = stringResource(R.string.logo),
            )
            QuizAppText(
                text = stringResource(R.string.app_name),
                style = QuizAppTheme.typography.heading1,
            )
            AnimatedLinearProgress()
            QuizAppText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                text = stringResource(R.string.splash_screen_title),
                style = QuizAppTheme.typography.heading2,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun SplashScreenPreview() {
    SplashScreen(
        uiEffect = emptyFlow(),
        onNavigateWelcome = {},
        onNavigateHome = {},
    )
}