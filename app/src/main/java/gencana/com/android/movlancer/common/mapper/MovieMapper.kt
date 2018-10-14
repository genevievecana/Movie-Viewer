package gencana.com.android.movlancer.common.mapper

import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.movlancer.common.constant.IMAGE_BASE_URL
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.model.PagingModel

/**
 * Created by Gen Cana on 14/10/2018
 */


fun Paging<Movie>.toPresentation(): PagingModel<MovieModel>
        = PagingModel(page, totalResults, totalPages, data?.map { it.toPresentation() })

fun Movie.toPresentation(): MovieModel =
        MovieModel(id, title, voteAverage,  posterPath?.let { "$IMAGE_BASE_URL$it" } )