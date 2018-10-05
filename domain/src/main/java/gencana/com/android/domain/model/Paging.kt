package gencana.com.android.domain.model

/**
 * Created by Gen Cana on 05/10/2018
 */
data class Paging<T> (
        var page: Int? = null,
        var totalResults: Int? = null,
        var totalPages: Int? = null,
        var data: List<T>? = null
)