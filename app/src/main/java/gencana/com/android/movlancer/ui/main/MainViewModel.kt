package gencana.com.android.movlancer.ui.main

import gencana.com.android.domain.interactor.GetMovieListInteractor
import gencana.com.android.domain.interactor.SearchMovieInteractor
import gencana.com.android.domain.model.SearchParams
import gencana.com.android.movlancer.common.base.BaseViewModel
import gencana.com.android.movlancer.common.mapper.toPresentation
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.model.PagingModel
import gencana.com.android.movlancer.common.model.Result
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gen Cana on 14/10/2018
 */

class MainViewModel @Inject constructor(
        private val interactor: GetMovieListInteractor,
        private val searchInteractor: SearchMovieInteractor,
        io: Scheduler)
    : BaseViewModel<PagingModel<MovieModel>, SearchParams>(io) {

    override fun getObservable(params: SearchParams): Observable<Result<PagingModel<MovieModel>>>
        = interactor.getObservable(params.page).toObservable()
            .map{ Result(it.toPresentation()) }

    fun searchObservable(params: SearchParams): Single<Result<PagingModel<MovieModel>>>
        = searchInteractor.getObservable(params)
            .map{ Result(it.toPresentation())}

}