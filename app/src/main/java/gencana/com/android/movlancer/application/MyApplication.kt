package gencana.com.android.movlancer.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import gencana.com.android.movlancer.di.DaggerAppComponent

/**
 * Created by Gen Cana on 05/10/2018
 */
class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .create(this)
                .build()
    }
}