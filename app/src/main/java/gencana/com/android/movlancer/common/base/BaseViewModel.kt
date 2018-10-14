package gencana.com.android.movlancer.common.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable
import java.security.InvalidParameterException

/**
 * Created by Gen Cana on 06/10/2018
 */

abstract class BaseViewModel<T, Params>(private val io: Scheduler) : ViewModel() {

    private val compositeDisposable by lazy { CompositeDisposable() }
    val responseLiveData by lazy { MutableLiveData<T>() }
    val loadingLiveData by lazy { MutableLiveData<Boolean>() }
    val errorLiveData by lazy { MutableLiveData<String>() }

    protected abstract fun getObservable(params: Params): Single<T>

    fun switchMapDefaultExecute(single: Observable<Params>){
        execute(single.switchMapSingle {  getObservable(it) })
    }

    fun execute(single: Observable<T>){
        addDisposable(single
                .subscribeOn(io)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { loadingLiveData.postValue(true) }
                .doAfterTerminate { loadingLiveData.postValue(false)}
                .retry() //TODO: error handling
                .subscribe({ result ->
                    responseLiveData.postValue(result)
                }, { throwable ->
                    if (throwable is InvalidParameterException)
                        errorLiveData.postValue(null)
                    else
                        errorLiveData.postValue(throwable.message)
                })
        )
    }

    fun addDisposable(disposable: Disposable?){
        disposable?.let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}