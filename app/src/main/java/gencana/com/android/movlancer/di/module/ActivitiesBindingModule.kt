package gencana.com.android.movlancer.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import gencana.com.android.movlancer.MainActivity

/**
 * Created by Gen Cana on 05/10/2018
 */
@Module
interface ActivitiesBindingModule {

    @ContributesAndroidInjector(modules = [])
    fun mainActivity(): MainActivity
}