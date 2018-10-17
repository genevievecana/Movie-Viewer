package gencana.com.android.movlancer.common.adapter.viewholder

import android.view.View
import gencana.com.android.movlancer.common.adapter.RecyclerViewMultiAdapter
import gencana.com.android.movlancer.common.model.HeaderModel
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_header.view.*

/**
 * Created by Gen Cana on 15/10/2018
 */
class HeaderViewHolder(private val view: View): RecyclerViewMultiAdapter.BaseViewHolder<HeaderModel>(view) {

    override fun onBind(data: HeaderModel, itemClickPublisher: PublishSubject<HeaderModel>?) {
        view.txt_header.text = data.header?: ""
    }
}