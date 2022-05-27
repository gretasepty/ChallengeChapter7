package binar.greta.challengechapter7.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.model.GetAllUser
import binar.greta.challengechapter7.model.GetAllUserItem
import binar.greta.challengechapter7.network.ApiClient
import binar.greta.challengechapter7.viewmodel.VMUser
import binar.greta.challengechapter7.viewmodel.VMUserr
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var userManager : UserManager
    lateinit var vm : VMUser
    lateinit var dataUser : List<GetAllUserItem>
    lateinit var password: String
    lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userManager = UserManager(this)
        getLogin()
//        userManager!!.userName.asLiveData().observe(this,{
//            if (it != ""){
//                startActivity(Intent(this, HomeActivity::class.java))
//            }
//        })

//      Button berpindah ke halaman register
        txt_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_login.setOnClickListener {
            if(edt_username.text.isNotEmpty() &&
                    edt_password.text.isNotEmpty()){
                username = edt_username.text.toString()
                password = edt_password.text.toString()
                dataLogin(dataUser)
            }else{
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getLogin(){
        vm = ViewModelProvider(this).get(VMUser::class.java)
        vm.getLiveLogin().observe(this,{
            dataUser = it
        })
        vm.LDLogin
    }

    fun dataLogin(dataUser : List<GetAllUserItem>){
        userManager = UserManager(this)
        apiLogin(password, username)
        for (a in dataUser.indices){
            if(password == dataUser[a].password &&
                    username == dataUser[a].username){
                GlobalScope.launch {
                    userManager.saveLogin("true")
                    userManager.saveData(dataUser[a].id,
                    dataUser[a].username,
                    dataUser[a].name,
                    dataUser[a].umur,
                    dataUser[a].address,
                    dataUser[a].password)
                }
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    fun apiLogin(password : String, username : String){
        ApiClient.instance.loginUser(password, username)
            .enqueue(object : Callback<GetAllUserItem>{
                override fun onResponse(
                    call: Call<GetAllUserItem>,
                    response: Response<GetAllUserItem>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@LoginActivity, "Data tidak boleh kosong", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@LoginActivity, "Username dan password salah", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<GetAllUserItem>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
    }

//    fun dataLogin(username : String, password : String){
//        val viewmodel = ViewModelProvider(this).get(VMUserr::class.java)
//        viewmodel.user.observe(this,{
//            GlobalScope.launch {
//                userManager.saveData(username)
//            }
//        })
//    }
}