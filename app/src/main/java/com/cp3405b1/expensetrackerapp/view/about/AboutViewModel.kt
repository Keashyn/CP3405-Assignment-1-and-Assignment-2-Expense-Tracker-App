package com.cp3405b1.expensetrackerapp.view.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class AboutViewModel @Inject constructor() : ViewModel() {
    private val _url = MutableStateFlow("https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52/tree/main/app/src/main/java/com/cp3405b1/expensetrackerapp")
    val url: StateFlow<String> = _url

    fun launchLicense() {
        _url.value = "https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52/tree/main/app/src/main/java/com/cp3405b1/expensetrackerapp"
    }

    fun launchRepository() {
        _url.value = "https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52/tree/main/app/src/main/java/com/cp3405b1/expensetrackerapp"
    }
}
