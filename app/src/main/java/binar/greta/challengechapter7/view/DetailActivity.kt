package binar.greta.challengechapter7.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.model.GetAllFilmItem
import binar.greta.challengechapter7.room.Film
import binar.greta.challengechapter7.room.FilmDB
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DetailActivity : AppCompatActivity() {

    var fav : Film?= null
    var favDB : FilmDB? = null

    lateinit var favorite: String
    lateinit var id: String
    lateinit var image: String
    lateinit var title: String
    lateinit var date: String
    lateinit var director: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        favDB = FilmDB.getInstance(this)

        val detailFilm = intent.getParcelableExtra<GetAllFilmItem>("detailfilm")
        val getfav = intent.getParcelableExtra<GetAllFilmItem>("detailfav")


        if(detailFilm != null){
            Glide.with(this).load(detailFilm?.image).into(img_detail)
            txt_judulDetail.text = detailFilm?.name
            txt_tanggalDetail.text = detailFilm?.date
            txt_sutradaraDetail.text = detailFilm?.director
            txt_deskDetail.text = detailFilm?.description

            val id = detailFilm.id.toString()
            val title = detailFilm.name.toString()
            val date = detailFilm.date.toString()
            val director = detailFilm.director.toString()
            val descrip = detailFilm.description.toString()
            val image = detailFilm.image.toString()
        }

        if(getfav != null){
            Glide.with(this).load(getfav?.image).into(img_detail)
            txt_judulDetail.text = getfav?.name
            txt_tanggalDetail.text = getfav?.date
            txt_sutradaraDetail.text = getfav?.director
            txt_deskDetail.text = getfav?.description

            id = getfav.id.toString()
            title = getfav.name.toString()
            date = getfav.date.toString()
            director = getfav.director.toString()
            description = getfav.description.toString()
            image = getfav.image.toString()
        }
    }

//    fun addFavorite(){
//        GlobalScope.async {
//            val result = favDB?.daoFilm()?.addFilm(
//                Film(
//                    date,
//
//                )
//            )
//        }
//    }
}