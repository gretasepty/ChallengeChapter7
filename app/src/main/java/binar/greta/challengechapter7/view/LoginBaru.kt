package binar.greta.challengechapter7.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.viewmodel.VMUserBaru
import kotlinx.android.synthetic.main.activity_login.*

class LoginBaru : AppCompatActivity() {

    lateinit var userManager: UserManagerBaru
    lateinit var usernameLogin : String
    lateinit var passwordLogin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_baru)

        userManager = UserManagerBaru(this)

        btn_login.setOnClickListener {
            if(edt_username.text.isNotEmpty() && edt_password.text.isNotEmpty()){
                datalogin()
//                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_LONG).show()
            }
        }

        userManager.userNama.asLiveData().observe(this,{
            usernameLogin = it.toString()
        })

        userManager.userPass.asLiveData().observe(this,{
            passwordLogin = it.toString()
        })

        txt_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    fun datalogin(){
        val usernameLog = edt_username.text.toString()
        val passwordLog = edt_password.text.toString()
        val viewModel = ViewModelProvider(this).get(VMUserBaru::class.java)
        viewModel.getLiveLogin().observe(this,{
            if (usernameLog == usernameLogin && passwordLog == passwordLogin){
                Toast.makeText(this, "Sukses login", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeLogin(passwordLog, usernameLog)

    }
}