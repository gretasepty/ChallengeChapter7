package binar.greta.challengechapter7.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import binar.greta.challengechapter7.R
import binar.greta.challengechapter7.room.Film
import binar.greta.challengechapter7.room.FilmDB
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_fav.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AdapterFavList(private var datafav: List<Film>) :
    RecyclerView.Adapter<AdapterFavList.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fav, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = datafav[position]
        holder.itemView.apply {
            txt_judulFav.text = data.name
            txt_tanggalFav.text = data.date
            txt_sutradaraFav.text = data.director
            Glide.with(holder.itemView.context).load(data.image)
                .into(holder.itemView.img_filmFav)

//  Menghapus favorite di halaman Favorite
            val mDB = FilmDB.getInstance(this.context)
            btn_FavList.setOnClickListener {
                GlobalScope.async {
                    val result = mDB!!.daoFilm().deleteFilm(data)
                    (holder.itemView.context as FavoriteActivity).runOnUiThread {
                        if (result != 0) {
                            btn_FavList.setBackgroundResource(R.drawable.favlist)
                            Toast.makeText(it.context, "Berhasil hapus", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(it.context, "Berhasil hapus", Toast.LENGTH_LONG).show()
                        }
                    }
                    (holder.itemView.context as FavoriteActivity).getFavorite()
                }
            }

        }
    }

        override fun getItemCount(): Int {
            return datafav.size
        }
    }