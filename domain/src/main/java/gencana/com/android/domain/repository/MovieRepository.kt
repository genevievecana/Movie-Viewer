package gencana.com.android.domain.repository

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Gen Cana on 28/09/2018
 */
interface MovieRepository {

    fun insertMovieList(movieList: List<Movie>): Completable

    fun getMovieList(page: Int): Single<Paging<Movie>>

    fun searchMovie(page: Int, query: String): Single<Paging<Movie>>
}