package gencana.com.android.movlancer.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import gencana.com.android.movlancer.common.constant.ViewModelKey
import gencana.com.android.movlancer.common.factory.ViewModelFactory
import gencana.com.android.movlancer.ui.main.MainViewModel

/**
 * Created by Gen Cana on 05/10/2018
 */
@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

}