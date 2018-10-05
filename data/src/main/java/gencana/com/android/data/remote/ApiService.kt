package gencana.com.android.data.remote

import gencana.com.android.data.BuildConfig
import gencana.com.android.data.entity.MovieDataEntity
import gencana.com.android.data.entity.PagingDataEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Gen Cana on 30/09/2018
 */
interface ApiService {

    @GET(POPULAR_MOVIE_ENDPOINT)
    fun getPopularMovieList(@Query(FIELD_PAGE) page: Int,
                            @Query(API_KEY) apiKey: String = BuildConfig.API_KEY)
            : Single<PagingDataEntity<MovieDataEntity>>

}