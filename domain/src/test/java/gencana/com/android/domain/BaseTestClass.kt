package gencana.com.android.domain

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.StandardSubjectBuilder
import com.google.common.truth.Truth
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Gen Cana on 30/09/2018
 */
@RunWith(MockitoJUnitRunner::class)
abstract class BaseTestClass {

    val assertBuilder: StandardSubjectBuilder by lazy {
        Truth.assert_()
    }

    @get:Rule
    val expectedException: ExpectedException by lazy {
        ExpectedException.none()
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { _ -> TestScheduler() }
        }
    }

    @Before
    fun init(){
        setup()
    }

    abstract fun setup()
}