package binar.greta.challengechapter7.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.greta.challengechapter7.model.GetAllFilmItem
import binar.greta.challengechapter7.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VMFilm @Inject constructor(apiService: ApiService)
    : ViewModel() {

    private var filmLiveData = MutableLiveData<List<GetAllFilmItem>>()
    val film : LiveData<List<GetAllFilmItem>> = filmLiveData

    init {
        viewModelScope.launch {
            val datafilm = apiService.getAllFilm()
            delay(2000)
            filmLiveData.value = datafilm
        }
    }

}