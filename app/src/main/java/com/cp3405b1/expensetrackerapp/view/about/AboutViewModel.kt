package com.cp3405b1.expensetrackerapp.view.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AboutViewModel : ViewModel() {
    private val _url = MutableStateFlow("https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52")
    val url: StateFlow<String> = _url

    fun launchLicense() {
        _url.value = "https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52"
    }

    fun launchRepository() {
        _url.value = "https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52"
    }
}
