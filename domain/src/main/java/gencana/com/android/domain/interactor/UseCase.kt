package gencana.com.android.domain.interactor

import io.reactivex.Observable
import io.reactivex.Single
import java.security.InvalidParameterException

/**
 * Created by Gen Cana on 28/09/2018
 */

abstract class  UseCase<T, Params>{

    protected abstract fun registerObservable(params: Params): Single<T>

    fun getObservable(params: Params): Single<T> {
        return if (!validateParams(params))
            Single.error(InvalidParameterException("Invalid Parameter"))
        else
            registerObservable(params)
    }

    open fun validateParams(params: Params): Boolean{
        return true
    }

}
