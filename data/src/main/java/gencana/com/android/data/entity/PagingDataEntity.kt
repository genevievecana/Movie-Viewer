package gencana.com.android.data.entity

import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

/**
 * Created by Gen Cana on 30/09/2018
 */
@JsonSerializable
open class PagingDataEntity<Data> (
        @Json(name = "page") var page: Int? = null,
        @Json(name = "total_results") var totalResults: Int? = null,
        @Json(name = "total_pages") var totalPages: Int? = null,
        @Json(name = "results") var data: List<Data>? = null
)