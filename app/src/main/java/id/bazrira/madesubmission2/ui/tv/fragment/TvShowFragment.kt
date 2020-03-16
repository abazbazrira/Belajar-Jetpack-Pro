package id.bazrira.madesubmission2.ui.tv.fragment


import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import id.bazrira.madesubmission2.R
import id.bazrira.madesubmission2.repo.tv.data.TvShows
import id.bazrira.madesubmission2.repo.tv.model.TvShowModel
import id.bazrira.madesubmission2.ui.tv.adapter.ListTvShowAdapter
import id.bazrira.madesubmission2.ui.tv.viewmodel.TvShowViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private lateinit var dataTitle: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataDesc: Array<String>
    private lateinit var dataImage: TypedArray

    private lateinit var tvShowViewModel: TvShowViewModel

    private val list = ArrayList<TvShows>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tv_show.setHasFixedSize(true)

        tvShowViewModel = TvShowViewModel(TvShowModel(this.requireContext()))

        showRecyclerList()
    }

    private fun showRecyclerList() {
        list.addAll(tvShowViewModel.getData())

        rv_tv_show.layoutManager = LinearLayoutManager(context)
        val listTvAdapter = ListTvShowAdapter(list)

        rv_tv_show.adapter = listTvAdapter
    }
}
