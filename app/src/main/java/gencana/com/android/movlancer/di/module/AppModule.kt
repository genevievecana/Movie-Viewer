package gencana.com.android.movlancer.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import gencana.com.android.movlancer.constant.SCHEDULER_IO
import gencana.com.android.movlancer.constant.SCHEDULER_MAIN_THREAD
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Gen Cana on 05/10/2018
 */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app : Application) : Context = app

    @Provides
    fun provideIoScheduler() : Scheduler = Schedulers.io()
}