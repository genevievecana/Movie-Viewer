package gencana.com.android.movlancer.common.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import gencana.com.android.movlancer.common.extensions.addObserver
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

/**
 * Created by Gen Cana on 06/10/2018
 */

abstract class BaseActivity<VM: BaseViewModel<T, *>, T>: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM
    protected abstract val layout: Int

    protected abstract fun setupActivity(savedInstanceState: Bundle?)
    protected abstract fun showLoading(show: Boolean)
    abstract fun onResponseSuccess(data: T)
    abstract fun onError(errorMsg: String?)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        observeLiveData()
        setupActivity(savedInstanceState)
    }

    private fun observeLiveData() {
        viewModel.responseLiveData.addObserver(this) { t: T -> onResponseSuccess(t)}
        viewModel.errorLiveData.addObserver(this) { t: String ->  onError(t)}
        viewModel.loadingLiveData.addObserver(this) { t: Boolean -> showLoading(t)}

    }
}
