package gencana.com.android.domain.interactor

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Gen Cana on 28/09/2018
 */
abstract class  UseCase<T, Params> (private val io: Scheduler){

    val loadingLiveData = MutableLiveData<Boolean>()

    abstract fun getObservable(params: Params? = null): Observable<T>

    fun execute(params: Params?) : Observable<T> {
        return getObservable(params)
                .doOnSubscribe { loadingLiveData.postValue(true) }
                .doAfterTerminate { loadingLiveData.postValue(false) }
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())

    }

}
