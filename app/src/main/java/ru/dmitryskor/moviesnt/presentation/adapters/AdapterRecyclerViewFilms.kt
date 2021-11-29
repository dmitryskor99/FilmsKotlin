package ru.dmitryskor.moviesnt.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.dmitryskor.moviesnt.R
import ru.dmitryskor.moviesnt.domain.entities.Film

class AdapterRecyclerViewFilms(private val context: Context?) :
    PagingDataAdapter<Film, AdapterRecyclerViewFilms.FilmsViewHolder>(MyDiffCallBack) {
    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false))
    }

    inner class FilmsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var imageViewMultimedia: ImageView? = null
        private var textViewTitleFilm: TextView? = null
        private var textViewSummaryShort: TextView? = null
        private var textViewOpeningDate: TextView? = null
        private var textViewRating: TextView? = null
        private var viewClick: View? = null

        init {
            textViewTitleFilm = itemView.findViewById(R.id.item_view__text_view__title_film)
            textViewSummaryShort = itemView.findViewById(R.id.item_view__summary_short__title_film)
            textViewOpeningDate = itemView.findViewById(R.id.item_view__opening_date__title_film)
            textViewRating = itemView.findViewById(R.id.item_view__text_view__rating)
            imageViewMultimedia = itemView.findViewById(R.id.item_view__image_view__multimedia)
            viewClick = itemView.findViewById(R.id.item_View__click_view)

        }

        fun bind(film: Film) {
            textViewTitleFilm?.text = if (film.displayTitle.isNullOrBlank()) "N/A" else film.displayTitle
            if (film.mpaaRating.isNullOrBlank())
                textViewRating?.visibility = View.GONE
            else
                textViewRating?.text = film.mpaaRating
            textViewSummaryShort?.text = film.summaryShort
            textViewOpeningDate?.text = film.openingDate
            Picasso
                .get()
                .load(film.multimedia?.src)
                .placeholder(R.drawable.ic_load_img_140)
                .error(R.drawable.ic_load_img_140)
                .into(imageViewMultimedia)

            viewClick?.setOnClickListener {
                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

object MyDiffCallBack: DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.displayTitle == newItem.displayTitle &&
                oldItem.summaryShort == newItem.summaryShort
    }

}