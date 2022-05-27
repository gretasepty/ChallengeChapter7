package binar.greta.challengechapter7.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.greta.challengechapter7.model.GetAllUserItem
import binar.greta.challengechapter7.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VMUserr @Inject constructor(apiService: ApiService)
    : ViewModel(){

//    private var userLiveData = MutableLiveData<List<GetAllUserItem>>()
//    val user : LiveData<List<GetAllUserItem>> = userLiveData
//
//    init {
//        viewModelScope.launch {
//            val datauser = apiService.getAllUser("")
//            delay(2000)
//            userLiveData.value = datauser
//        }
//    }
}