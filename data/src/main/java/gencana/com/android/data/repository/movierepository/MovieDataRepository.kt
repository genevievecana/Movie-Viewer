package gencana.com.android.data.repository.movierepository

import gencana.com.android.data.entity.MovieDataEntity
import gencana.com.android.data.entity.mapper.toDomain
import gencana.com.android.data.repository.movierepository.datastore.MovieDataStoreFactory
import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gen Cana on 30/09/2018
 */

@Singleton
class MovieDataRepository @Inject constructor(
        factory: MovieDataStoreFactory)
    : MovieRepository {

    private var dataStoreFactory = factory.create()

    override fun insertMovieList(movieList: List<Movie>): Completable {
           return dataStoreFactory.addMovieList(movieList.map {
               MovieDataEntity(it.id)
           })
    }

    override fun getMovieList(page: Int): Single<Paging<Movie>> {
        return dataStoreFactory.getMovieList(page).map { it.toDomain() }
    }

}