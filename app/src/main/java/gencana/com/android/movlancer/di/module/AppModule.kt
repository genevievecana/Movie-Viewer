package gencana.com.android.movlancer.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
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