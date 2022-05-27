package binar.greta.challengechapter7.view

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {
    private val dataUser : DataStore<Preferences> = context.createDataStore("user_prefs")
    private val dataLogin : DataStore<Preferences> = context.createDataStore("user_login")

    companion object{
        val ID = preferencesKey<String>("USER_ID")
        val USERNAME = preferencesKey<String>("USER_NAME")
        val NAMA = preferencesKey<String>("USER_NAMA")
        val UMUR = preferencesKey<String>("USER_UMUR")
        val ALAMAT = preferencesKey<String>("USER_ALAMAT")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
        val KEY = preferencesKey<String>("USER_KEY")
    }

    suspend fun saveData(id : String, username : String,
    nama : String, umur :String, alamat : String, password : String){
        dataUser.edit{
            it[ID] = username
            it[USERNAME] = username
            it[NAMA] = nama
            it[UMUR] = umur
            it[ALAMAT] = alamat
            it[PASSWORD] = password
        }
    }

    suspend fun saveLogin(key : String){
        dataLogin.edit {
            it[KEY] = key
        }
    }

    val userId : Flow<String> = dataUser.data.map {
        it[ID]?: ""
    }

    val userName : Flow<String> = dataUser.data.map {
        it[USERNAME]?: ""
    }

    val userNama : Flow<String> = dataUser.data.map {
        it[NAMA]?: ""
    }
    val userUmur : Flow<String> = dataUser.data.map {
        it[UMUR]?: ""
    }

    val userAlamat : Flow<String> = dataUser.data.map {
        it[ALAMAT]?: ""
    }

    val userPassword : Flow<String> = dataUser.data.map {
        it[PASSWORD]?: ""
    }
    val userKey: Flow<String> = dataLogin.data.map {
        it[KEY]?: ""
    }


}