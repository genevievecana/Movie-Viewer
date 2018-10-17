package gencana.com.android.movlancer.common.model

import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderEnum
import gencana.com.android.movlancer.common.adapter.viewholder.factory.ViewHolderInterface

/**
 * Created by Gen Cana on 15/10/2018
 */
class HeaderModel(val header: String? = null): ViewHolderInterface {
    override var viewType: Int? = ViewHolderEnum.HEADER.type
}