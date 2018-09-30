package gencana.com.android.domain.repository

import gencana.com.android.domain.model.Movie
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Gen Cana on 28/09/2018
 */
interface MovieRepository {

    fun insertMovieList(movieList: List<Movie>): Completable

    fun getMovieList(page: Int): Observable<List<Movie>>
}