package gencana.com.android.domain.interactor

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.domain.model.SearchParams
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gen Cana on 15/10/2018
 */

class SearchMovieInteractor
@Inject constructor(
        private val repository: MovieRepository)
    : UseCase<Paging<Movie>, SearchParams>(){

    override fun registerObservable(params: SearchParams): Single<Paging<Movie>> {
        return repository.searchMovie(params.page, params.query!!)
    }
}