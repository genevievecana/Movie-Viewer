package gencana.com.android.movlancer.ui.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import gencana.com.android.domain.model.SearchParams
import gencana.com.android.movlancer.R
import gencana.com.android.movlancer.common.adapter.RecyclerViewMultiAdapter
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderInterface
import gencana.com.android.movlancer.common.base.BaseActivity
import gencana.com.android.movlancer.common.extensions.defaultMultiAdapter
import gencana.com.android.movlancer.common.extensions.invisible
import gencana.com.android.movlancer.common.extensions.show
import gencana.com.android.movlancer.common.model.HeaderModel
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.model.PagingModel
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error.*

class MainActivity : BaseActivity<MainViewModel, PagingModel<MovieModel>>() {

    private lateinit var multiAdapter: RecyclerViewMultiAdapter<ViewHolderInterface>


    override val layout: Int = R.layout.activity_main

    override fun setupActivity(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        viewModel.switchMapDefaultExecute(Observable.just(SearchParams(1)))
        multiAdapter = recycler_view.defaultMultiAdapter(layoutManager = GridLayoutManager(this, 2))
    }

    override fun showLoading(show: Boolean) {
        swipe_refresh.isRefreshing = show
    }

    override fun onResponseSuccess(data: PagingModel<MovieModel>) {
        layout_error.show(false)
        recycler_view.show()

        multiAdapter.addItem( HeaderModel(getString(R.string.header_movie)))
        multiAdapter.addItem( HeaderModel(), false) //TODO: setspansizelookup instead
        multiAdapter.addItems( data.data!!)
    }

    override fun onError(errorMsg: String?) {
        recycler_view.invisible()
        layout_error.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        setupSearch(menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupSearch(menu: Menu?){
        menu?.apply { viewModel.execute(Observable.create<SearchParams> {
                    (findItem(R.id.action_search).actionView as SearchView).apply {
                        maxWidth = Integer.MAX_VALUE
                        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                            override fun onQueryTextChange(newText: String?): Boolean {
                                return true
                            }

                            override fun onQueryTextSubmit(query: String?): Boolean {
                                it.onNext(SearchParams(1, query!!))
                                return false
                            }

                        })
                    }
                }.switchMapSingle { viewModel.searchObservable(it) }) }
    }

}
