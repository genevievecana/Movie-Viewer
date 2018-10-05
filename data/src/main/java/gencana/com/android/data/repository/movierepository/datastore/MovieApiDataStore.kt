package gencana.com.android.data.repository.movierepository.datastore

import gencana.com.android.data.entity.MovieDataEntity
import gencana.com.android.data.remote.ApiService
import gencana.com.android.data.entity.PagingDataEntity
import io.reactivex.Completable
import io.reactivex.Single


/**
 * Created by Gen Cana on 30/09/2018
 */
class MovieApiDataStore(private val apiService: ApiService): MovieDataStore {

    //TODO
    override fun addMovieList(movieList: List<MovieDataEntity>): Completable {
        return Completable.complete()
    }

    override fun getMovieList(page: Int): Single<PagingDataEntity<MovieDataEntity>> {
        return apiService.getPopularMovieList(page)

    }
}