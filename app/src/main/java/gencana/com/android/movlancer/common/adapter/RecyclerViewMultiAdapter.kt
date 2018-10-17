package gencana.com.android.movlancer.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderEnum
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderFactory
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderInterface
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Gen Cana on 14/10/2018
 */

class RecyclerViewMultiAdapter<E: ViewHolderInterface>(
        private val itemList: MutableList<E>,
        private val itemClickPublisher: PublishSubject<E>?
) : RecyclerView.Adapter<RecyclerViewMultiAdapter.BaseViewHolder<E>>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        return ViewHolderFactory.createViewType(parent, viewType) as BaseViewHolder<E>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        holder.onBind(itemList[position], itemClickPublisher)
    }

    internal inline fun <reified R>getClickObservable(): Observable<R>?{
        return itemClickPublisher
                ?.filter{it is R }
                ?.map { it as R }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].viewType ?: ViewHolderEnum.ITEM.type
    }

    //TODO: replace paging
    fun addItem(item: E, isClear: Boolean = true){
        if (isClear) {
            itemList.clear()
        }
        itemList.add(item)
        notifyDataSetChanged()
    }

    //TODO: replace paging
    fun addItems(items: List<E>, isClear: Boolean = false){
        if (isClear) {
            itemList.clear()
        }
        itemList.addAll(items)
        notifyDataSetChanged()
    }


    abstract class BaseViewHolder<E : ViewHolderInterface>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun onBind(data: E, itemClickPublisher: PublishSubject<E>?)
    }

}