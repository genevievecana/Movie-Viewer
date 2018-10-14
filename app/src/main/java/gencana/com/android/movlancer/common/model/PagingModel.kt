package gencana.com.android.movlancer.common.model

/**
 * Created by Gen Cana on 14/10/2018
 */
data class PagingModel<T> (
        var page: Int? = null,
        var totalResults: Int? = null,
        var totalPages: Int? = null,
        var data: List<T>? = null
)