package gencana.com.android.movlancer.common.extensions

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import gencana.com.android.movlancer.common.adapter.RecyclerViewMultiAdapter
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderInterface
import io.reactivex.subjects.PublishSubject

/**
 * Created by Gen Cana on 07/10/2018
 */


fun <E: ViewHolderInterface> RecyclerView.defaultMultiAdapter(
        itemList: ArrayList<E> = ArrayList(), layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context))
        : RecyclerViewMultiAdapter<E>{
    setLayoutManager(layoutManager)
    val multiAdapter = RecyclerViewMultiAdapter(itemList, PublishSubject.create())
    adapter = multiAdapter
    return multiAdapter
}