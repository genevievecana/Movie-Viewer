package gencana.com.android.movlancer.common.model

/**
 * Created by Gen Cana on 17/10/2018
 */

data class Result<T>(var data: T? = null,
                     val error: String? = null){

    fun hasError(): Boolean{
        return error != null
    }
}