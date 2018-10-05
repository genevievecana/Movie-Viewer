package gencana.com.android.data.di

import dagger.Module
import dagger.Provides
import gencana.com.android.data.repository.movierepository.MovieDataRepository
import gencana.com.android.domain.repository.MovieRepository
import javax.inject.Singleton

/**
 * Created by Gen Cana on 30/09/2018
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun providesMovieRepository(dataRepository: MovieDataRepository): MovieRepository
            = dataRepository

}