package id.bazrira.madesubmission2.repo.movie.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var title: String,
    var duration: String,
    var genre: String,
    var image: Int,
    var desc: String
) : Parcelable