package gencana.com.android.movlancer.common.adapter.viewholder.factory

import gencana.com.android.movlancer.R

/**
 * Created by Gen Cana on 14/10/2018
 */

enum class ViewHolderEnum(val type: Int, val layout: Int) {

    ITEM(0, R.layout.item_movie);


    companion object {

        fun getViewHolderType(type: Int): ViewHolderEnum?{
            ViewHolderEnum.values().forEach {
                if (it.type == type){
                    return it
                }
            }

            return null
        }
    }
}