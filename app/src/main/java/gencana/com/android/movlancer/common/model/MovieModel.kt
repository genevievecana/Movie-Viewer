package gencana.com.android.movlancer.common.model

import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderEnum
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderInterface

/**
 * Created by Gen Cana on 14/10/2018
 */

data class MovieModel(val id: Int,
                      val title: String,
                      val voteAverage: Float,
                      val posterPath: String)
    : ViewHolderInterface{

    override var viewType: Int? = ViewHolderEnum.ITEM.type

}