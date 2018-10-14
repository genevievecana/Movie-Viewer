package gencana.com.android.movlancer.ui.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import gencana.com.android.movlancer.R
import gencana.com.android.movlancer.common.adapter.RecyclerViewMultiAdapter
import gencana.com.android.movlancer.common.base.BaseActivity
import gencana.com.android.movlancer.common.extensions.defaultMultiAdapter
import gencana.com.android.movlancer.common.extensions.invisible
import gencana.com.android.movlancer.common.extensions.show
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.model.PagingModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error.*

class MainActivity : BaseActivity<MainViewModel, PagingModel<MovieModel>>() {

    private lateinit var multiAdapter: RecyclerViewMultiAdapter<MovieModel>

    override val layout: Int = R.layout.activity_main

    override fun setupActivity(savedInstanceState: Bundle?) {
        multiAdapter = recycler_view.defaultMultiAdapter(
                layoutManager = GridLayoutManager(this, 2))
        viewModel.execute(1)
    }

    override fun showLoading(show: Boolean) {
        swipe_refresh.isRefreshing = show
    }

    override fun onResponseSuccess(data: PagingModel<MovieModel>) {
        layout_error.show(false)
        swipe_refresh.show()
        multiAdapter.addItems(data.data!!)
    }

    override fun onError(errorMsg: String?) {
        swipe_refresh.invisible()
        layout_error.show()
    }

}
