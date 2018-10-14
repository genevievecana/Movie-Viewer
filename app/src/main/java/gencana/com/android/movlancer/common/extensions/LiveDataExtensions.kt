package gencana.com.android.movlancer.common.extensions

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer


/**
 * Created by Gen Cana on 13/10/2018
 */

fun <T> LiveData<T>.addObserver(owner: LifecycleOwner, t: (T)-> Unit){
    observe(owner, Observer {
        it?.let { it1 -> t.invoke(it1) }
    })
}