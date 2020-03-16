package id.bazrira.madesubmission2.repo.tv.model

import android.content.Context
import android.content.res.TypedArray
import id.bazrira.madesubmission2.R
import id.bazrira.madesubmission2.repo.tv.data.TvShows

class TvShowModel(private val context: Context) {

    private lateinit var dataTitle: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataImage: TypedArray

    fun getData(): ArrayList<TvShows> {
        dataTitle = context.resources.getStringArray(R.array.tv_title)
        dataDesc = context.resources.getStringArray(R.array.tv_desc)
        dataGenre = context.resources.getStringArray(R.array.tv_genre)
        dataImage = context.resources.obtainTypedArray(R.array.tv_image)
        dataDuration = context.resources.getStringArray(R.array.tv_duration)

        val listTvs = ArrayList<TvShows>()
        for (position in dataTitle.indices) {
            val tvShows = TvShows(
                dataTitle[position],
                dataDuration[position],
                dataGenre[position],
                dataImage.getResourceId(position, -1),
                dataDesc[position]
            )
            listTvs.add(tvShows)
        }

        return listTvs
    }
}