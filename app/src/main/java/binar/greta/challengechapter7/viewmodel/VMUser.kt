package binar.greta.challengechapter7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.greta.challengechapter7.model.GetAllUserItem
import binar.greta.challengechapter7.network.ApiClient
import binar.greta.challengechapter7.view.UserManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VMUser : ViewModel() {
    private var userManager : UserManager? = null

    lateinit var LDLogin : MutableLiveData<List<GetAllUserItem>>

    init{
        LDLogin = MutableLiveData()
    }


    fun getLiveLogin() : MutableLiveData<List<GetAllUserItem>>{
        return LDLogin
    }

////    Login
//    fun dataLogin(password : String, username : String){
//        ApiClient.instance.loginUser(password, username)
//            .enqueue(object  : Callback<GetAllUserItem>{
//                override fun onResponse(
//                    call: Call<GetAllUserItem>,
//                    response: Response<GetAllUserItem>
//                ) {
//                    if (response.isSuccessful){
//                        LDLogin.postValue(response.body())
//
//                    }else{
//                        LDLogin.postValue(null)
//                    }
//                }
//                override fun onFailure(call: Call<GetAllUserItem>, t: Throwable) {
//                    LDLogin.postValue(null)
//                }
//            })
//    }

    fun makeApi(){
        ApiClient.instance.allUser()
            .enqueue(object : Callback<List<GetAllUserItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUserItem>>,
                    response: Response<List<GetAllUserItem>>
                ) {
                    if(response.isSuccessful){
                        LDLogin.postValue(response.body())
                    }else{
                        LDLogin.postValue(null)
                    }
                }
                override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                    LDLogin.postValue(null)
                }
            })
    }

}