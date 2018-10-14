package gencana.com.android.domain.interactor

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Gen Cana on 28/09/2018
 */
class GetMovieListInteractor
@Inject constructor(
        private val repository: MovieRepository)
    : UseCase<Paging<Movie>, Int>(){

    override fun registerObservable(params: Int): Single<Paging<Movie>> {
        return repository.getMovieList(params)
    }
}