package id.bazrira.madesubmission2.ui.movie.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.bazrira.madesubmission2.repo.movie.data.Movies
import id.bazrira.madesubmission2.R
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val film = intent.getParcelableExtra(EXTRA_MOVIE) as Movies
        tv_detail_genre.text = film.genre
        tv_detail_duration.text = film.duration
        tv_detail_title.text = film.title
        tv_detail_desc.text = film.desc

        Glide.with(this)
            .load(film.image)
            .apply(RequestOptions().override(500, 750))
            .into(iv_poster)

        Glide.with(this)
            .load(film.image)
            .centerCrop()
            .into(bg)

        supportActionBar?.title = getString(R.string.title_1)
    }
}
