package gencana.com.android.domain.interactor

import android.arch.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Gen Cana on 28/09/2018
 */
abstract class  UseCaseCompletable<Params> (private val io: Scheduler){

    val loadingLiveData = MutableLiveData<Boolean>()

    abstract fun getObservable(params: Params? = null): Completable

    fun execute(params: Params?) : Completable {
        return getObservable(params)
                .doOnSubscribe { loadingLiveData.postValue(true) }
                .doAfterTerminate { loadingLiveData.postValue(false) }
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())

    }

}
