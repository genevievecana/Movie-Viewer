package gencana.com.android.movlancer.common.adapter.viewholder

import android.view.View
import gencana.com.android.movlancer.application.GlideApp
import gencana.com.android.movlancer.common.model.MovieModel
import gencana.com.android.movlancer.common.adapter.RecyclerViewMultiAdapter
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Gen Cana on 14/10/2018
 */

class MovieViewHolder(private val view: View) : RecyclerViewMultiAdapter.BaseViewHolder<MovieModel>(view) {

    override fun onBind(data: MovieModel, itemClickPublisher: PublishSubject<MovieModel>?) {
        GlideApp.with(view).load(data.posterPath).into(view.img_poster)
        view.rating_bar.rating = data.voteAverage/2
        view.rating_bar.alpha = 1f
        view.txt_title.text = data.title
    }


}