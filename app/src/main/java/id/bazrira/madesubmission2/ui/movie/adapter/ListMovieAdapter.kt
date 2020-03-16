package id.bazrira.madesubmission2.ui.movie.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.bazrira.madesubmission2.repo.movie.data.Movies
import id.bazrira.madesubmission2.R
import id.bazrira.madesubmission2.ui.movie.activity.DetailMovieActivity
import kotlinx.android.synthetic.main.item_row_movie.view.*

class ListMovieAdapter(private val listMovies: ArrayList<Movies>) : RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: Movies) {
            with(itemView) {
                tv_title.text = movies.title
                tv_content_duration.text = movies.duration
                tv_content_genre.text = movies.genre
                Glide.with(itemView.context)
                    .load(movies.image)
                    .apply(RequestOptions().override(500, 750))
                    .into(iv_poster)

                btn_detail_movie.setOnClickListener {
                    val movie =
                        Movies(
                            movies.title,
                            movies.duration,
                            movies.genre,
                            movies.image,
                            movies.desc
                        )

                    val moveWithObjectIntent = Intent(context, DetailMovieActivity::class.java)
                    moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
                    context.startActivity(moveWithObjectIntent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

}