package gencana.com.android.domain.interactor

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by Gen Cana on 28/09/2018
 */
class AddMovieListInteractor
@Inject constructor(
        private val repository: MovieRepository,
        io: Scheduler)
    : UseCaseCompletable<List<Movie>>(io){

    override fun getObservable(params: List<Movie>?): Completable{
        return repository.insertMovieList(params!!)
    }

}