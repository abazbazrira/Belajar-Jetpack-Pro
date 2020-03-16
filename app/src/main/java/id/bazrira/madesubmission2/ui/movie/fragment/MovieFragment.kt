package id.bazrira.madesubmission2.ui.movie.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.bazrira.madesubmission2.R
import id.bazrira.madesubmission2.repo.movie.data.Movies
import id.bazrira.madesubmission2.repo.movie.model.MovieModel
import id.bazrira.madesubmission2.ui.movie.adapter.ListMovieAdapter
import id.bazrira.madesubmission2.ui.movie.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private val list = ArrayList<Movies>()

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movies.setHasFixedSize(true)

        movieViewModel = MovieViewModel(MovieModel(), this.requireContext())

        showRecyclerList()
    }

    private fun showRecyclerList() {
        list.addAll(movieViewModel.getData())

        rv_movies.layoutManager = LinearLayoutManager(context)
        val listMovieAdapter = ListMovieAdapter(list)

        rv_movies.adapter = listMovieAdapter
    }

}
