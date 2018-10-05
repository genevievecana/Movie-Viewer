package gencana.com.android.data.repository.movierepository.datastore

import gencana.com.android.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Gen Cana on 30/09/2018
 */
@Singleton
class MovieDataStoreFactory @Inject constructor(
        private val apiService: ApiService){

    fun create(): MovieDataStore{
        val dataStore = MovieApiDataStore(apiService)
        return dataStore
    }


}