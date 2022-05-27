package binar.greta.challengechapter7.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.viewmodel.VMUserBaru
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    lateinit var userManagerBaru: UserManagerBaru

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userManagerBaru = UserManagerBaru(this)

        btn_register.setOnClickListener {
            if (edt_usernameReg.text.isNotEmpty() &&
                edt_passwordReg.text.isNotEmpty() &&
                edt_konPassReg.text.isNotEmpty()){
                if(edt_passwordReg.text.toString() != edt_konPassReg.text.toString()){
                    Toast.makeText(this, "Konfirmasi password salah", Toast.LENGTH_LONG).show()
                }else{
                    dataRegister()
                }
            }else{
                Toast.makeText(this, "Data kosong", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun dataRegister(){
        val usernameReg = edt_usernameReg.text.toString()
        val passwordReg = edt_passwordReg.text.toString()
        val konPass = edt_konPassReg.text.toString()

        val viewModel = ViewModelProvider(this).get(VMUserBaru::class.java)
        viewModel.getLiveRegister().observe(this, {
            GlobalScope.launch {
                userManagerBaru.saveData("", usernameReg, passwordReg, "", "", "")
                startActivity(Intent(this@RegisterActivity, LoginBaru::class.java))
            }
        } )
        viewModel.makeRegister(passwordReg, usernameReg)
    }
}