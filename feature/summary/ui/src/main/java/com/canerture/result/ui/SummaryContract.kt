package com.canerture.result.ui

internal object SummaryContract {
    data class UiState(
        val isLoading: Boolean = false,
        val quizId: Int = 0,
        val correctAnswers: String = "0",
        val wrongAnswers: String = "0",
        val score: Int = 0,
        val state: SummaryState = SummaryState.EQUAL,
    )

    sealed interface UiAction {
        data object OnCloseClick : UiAction
        data object OnPlayAgainClick : UiAction
    }

    sealed interface UiEffect {
        data object NavigateBack : UiEffect
        data class NavigateQuiz(val quizId: Int) : UiEffect
    }
}