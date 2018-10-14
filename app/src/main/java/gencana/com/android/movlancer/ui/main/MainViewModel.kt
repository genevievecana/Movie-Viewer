package gencana.com.android.movlancer.ui.main

import gencana.com.android.domain.interactor.GetMovieListInteractor
import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.movlancer.common.base.BaseViewModel
import gencana.com.android.movlancer.common.mapper.toPresentation
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.model.PagingModel
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gen Cana on 14/10/2018
 */

class MainViewModel @Inject constructor(
        private val interactor: GetMovieListInteractor,
        io: Scheduler)
    : BaseViewModel<PagingModel<MovieModel>, Int>(io) {



    override fun getObservable(params: Int): Single<PagingModel<MovieModel>> {
        return interactor.getObservable(params)
                .map(Paging<Movie>::toPresentation)

    }

}