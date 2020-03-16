package id.bazrira.madesubmission2.ui.tv.viewmodel

import androidx.lifecycle.ViewModel
import id.bazrira.madesubmission2.repo.tv.data.TvShows
import id.bazrira.madesubmission2.repo.tv.model.TvShowModel

class TvShowViewModel(private val tvShowModel: TvShowModel) : ViewModel() {

    fun getData(): ArrayList<TvShows> = tvShowModel.getData()

}