package gencana.com.android.domain.interactor

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by Gen Cana on 28/09/2018
 */
class GetMovieListInteractor
@Inject constructor(
        private val repository: MovieRepository,
        io: Scheduler)
    : UseCase<Paging<Movie>, Int>(io){

    override fun getObservable(params: Int): Observable<Paging<Movie>> {
        return repository.getMovieList(params).toObservable()
    }

}