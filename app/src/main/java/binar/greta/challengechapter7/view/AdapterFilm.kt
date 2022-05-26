package binar.greta.challengechapter7.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.model.GetAllFilmItem
import binar.greta.challengechapter7.room.FilmDB
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*

class AdapterFilm( private var onClick :(GetAllFilmItem) -> Unit) : RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    private var datafilm : List<GetAllFilmItem>?= null
    fun setdatafilm(film : List<GetAllFilmItem>){
        this.datafilm = film
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film,parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_sutradara.text = datafilm!![position].director
        holder.itemView.txt_tanggal.text = datafilm!![position].date
        holder.itemView.txt_judul.text = datafilm!![position].name

        Glide.with(holder.itemView.context).load(datafilm!![position].image)
            .into(holder.itemView.img_film)

        holder.itemView.cardFilm.setOnClickListener{
            onClick(datafilm!![position])
        }


    }

    override fun getItemCount(): Int {
        if(datafilm == null){
            return 0
        }else{
            return datafilm!!.size
        }
    }
}