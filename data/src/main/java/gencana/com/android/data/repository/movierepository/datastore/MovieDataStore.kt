package gencana.com.android.data.repository.movierepository.datastore

import gencana.com.android.data.entity.MovieDataEntity
import gencana.com.android.data.entity.PagingDataEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Gen Cana on 30/09/2018
 */
interface MovieDataStore {

    fun addMovieList(movieList: List<MovieDataEntity>): Completable

    fun getMovieList(page: Int) : Single<PagingDataEntity<MovieDataEntity>>

    fun searchMovie(page: Int, query: String): Single<PagingDataEntity<MovieDataEntity>>
}