package gencana.com.android.data.entity

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by Gen Cana on 30/09/2018
 */
@JsonSerializable
data class MovieDataEntity(val id: Int,
                           val title: String,
                           @Json(name = "vote_average") val voteAverage: Float,
                           @Json(name = "poster_path") val posterPath: String)
    : PagingDataEntity<MovieDataEntity>()