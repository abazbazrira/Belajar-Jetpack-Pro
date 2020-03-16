package id.bazrira.madesubmission2.ui.movie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import id.bazrira.madesubmission2.repo.movie.model.MovieModel
import id.bazrira.madesubmission2.repo.movie.data.Movies

class MovieViewModel(private val movieModel: MovieModel, private val context: Context) : ViewModel() {

    fun getData(): ArrayList<Movies> = movieModel.getData(context)

}