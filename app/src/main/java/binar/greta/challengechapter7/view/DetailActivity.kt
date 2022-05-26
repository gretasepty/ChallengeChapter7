package binar.greta.challengechapter7.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.model.GetAllFilmItem
import binar.greta.challengechapter7.room.FilmDB
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailFilm = intent.getParcelableExtra<GetAllFilmItem>("detailfilm")

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



    }
}