package gencana.com.android.movlancer.common.adapter.viewholder.factory

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gencana.com.android.movlancer.common.adapter.viewholder.MovieViewHolder

/**
 * Created by Gen Cana on 14/10/2018
 */

object ViewHolderFactory {

    fun createViewType(parent: ViewGroup, type: Int): RecyclerView.ViewHolder{
        val viewTypeEnum: ViewHolderEnum = ViewHolderEnum.getViewHolderType(type)
                ?: throw NullPointerException("Invalid ViewHolder Type")

        val view: View = LayoutInflater.from(parent.context)
                .inflate(viewTypeEnum.layout, parent, false)
        return when(viewTypeEnum){
            ViewHolderEnum.ITEM -> MovieViewHolder(view)
        }
    }

}