package gencana.com.android.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * Created by Gen Cana on 30/09/2018
 */

open class TestLiveDataObserver<T> : Observer<T> {

    val observedValues = mutableListOf<T?>()

    override fun onChanged(value: T?) {
        observedValues.add(value)
    }
}

fun <T> LiveData<T>.testObserver() = TestLiveDataObserver<T>().also {
    observeForever(it)
}