package binar.greta.challengechapter7.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.room.FilmDB
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
//
//        getFavorite()
    }

//    fun getFavorite(){
//        val mDB = FilmDB.getInstance(this)
//        GlobalScope.launch {
//            val a = mDB!!.daoFilm().getFilm()
//            runOnUiThread {
//                if (a != null){
//                    rv_film.layoutManager = LinearLayoutManager(this@FavoriteActivity)
//                    rv_film.adapter = AdapterFavList(a)
//                }
//            }
//        }
//    }
}