package gencana.com.android.movlancer.application

import android.content.Context
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import gencana.com.android.movlancer.common.constant.IMAGE_RADIUS


/**
 * Created by Gen Cana on 14/10/2018
 */

@GlideModule
class MyGlideModule: AppGlideModule(){
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions(getDefaultRequestOptions())
    }


    private fun getDefaultRequestOptions(): RequestOptions
        = RequestOptions()
                .fitCenter()
                .transform(RoundedCorners(IMAGE_RADIUS))

}