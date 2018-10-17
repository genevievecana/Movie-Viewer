package gencana.com.android.movlancer.common.extensions

import gencana.com.android.movlancer.common.model.Result
import io.reactivex.Observable

/**
 * Created by Gen Cana on 17/10/2018
 */

fun <T> Observable<Result<T>>.addErrorHandler(): Observable<Result<T>> {
    return onErrorResumeNext{throwable: Throwable -> Observable.just(Result(error = throwable.message)) }
}