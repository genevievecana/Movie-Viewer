package gencana.com.android.movlancer.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import gencana.com.android.data.di.DataModule
import gencana.com.android.movlancer.application.MyApplication
import gencana.com.android.movlancer.di.module.ActivitiesBindingModule
import gencana.com.android.movlancer.di.module.AppModule
import javax.inject.Singleton

/**
 * Created by Gen Cana on 05/10/2018
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivitiesBindingModule::class,
    DataModule::class
])

interface AppComponent: AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }
}