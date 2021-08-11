package dev.CP3405B1.expensetracker.view.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class AboutViewModel : ViewModel() {
    private val _url = MutableStateFlow("")
    val url: StateFlow<String> = _url

    fun launchLicense() {
        _url.value = ""
    }

    fun launchRepository() {
        _url.value = ""
    }
}
