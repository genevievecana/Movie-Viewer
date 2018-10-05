package gencana.com.android.data.entity.mapper

import gencana.com.android.data.entity.MovieDataEntity
import gencana.com.android.data.entity.PagingDataEntity
import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging

/**
 * Created by Gen Cana on 05/10/2018
 */

fun PagingDataEntity<MovieDataEntity>.toDomain(): Paging<Movie>
        = Paging(page, totalResults, totalPages, data?.map { it.toDomain() })


fun MovieDataEntity.toDomain(): Movie =
        Movie(id)
