package id.bazrira.madesubmission2.repo.movie.model

import android.content.Context
import android.content.res.TypedArray
import id.bazrira.madesubmission2.R
import id.bazrira.madesubmission2.repo.movie.data.Movies

class MovieModel {

    private lateinit var dataTitle: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataImage: TypedArray

    fun getData(context: Context): ArrayList<Movies> {
        dataTitle = context.resources.getStringArray(R.array.data_title)
        dataDesc = context.resources.getStringArray(R.array.data_description)
        dataGenre = context.resources.getStringArray(R.array.data_genre)
        dataImage = context.resources.obtainTypedArray(R.array.data_image)
        dataDuration = context.resources.getStringArray(R.array.data_duration)

        val listMovie = ArrayList<Movies>()

        for (position in dataTitle.indices) {
            val movie = Movies(
                dataTitle[position],
                dataDuration[position],
                dataGenre[position],
                dataImage.getResourceId(position, -1),
                dataDesc[position]
            )
            listMovie.add(movie)
        }

        return listMovie
    }
}