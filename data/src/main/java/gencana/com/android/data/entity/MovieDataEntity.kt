package gencana.com.android.data.entity

import se.ansman.kotshi.JsonSerializable

/**
 * Created by Gen Cana on 30/09/2018
 */
@JsonSerializable
data class MovieDataEntity(var id: Int?)
    : PagingDataEntity<MovieDataEntity>()