package binar.greta.challengechapter7.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.viewmodel.VMFilm
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.item_film.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getHome()

        btnPerson.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btnFav.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

//        btnFavList.setOnClickListener {
//            startActivity(Intent(this, ProfileActivity::class.java))
//        }
    }

    fun getHome(){
        val filmadapter = AdapterFilm(){
            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtra("detailfilm", it)
            startActivity(pindah)
        }
        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = filmadapter

        val viewmodel = ViewModelProvider(this).get(VMFilm::class.java)
        viewmodel.film.observe(this, {
            if(it != null){
                filmadapter.setdatafilm(it)
                filmadapter.notifyDataSetChanged()
            }
        })
    }
}