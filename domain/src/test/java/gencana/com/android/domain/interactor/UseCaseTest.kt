package gencana.com.android.domain.interactor

import gencana.com.android.domain.BaseTestClass
import gencana.com.android.domain.TestLiveDataObserver
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import gencana.com.android.domain.testObserver
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import java.security.InvalidParameterException
import org.mockito.Mockito.`when` as whenever

/**
 * Created by Gen Cana on 30/09/2018
 */

class UseCaseTest: BaseTestClass(){

    private lateinit var useCase: UseCaseClass

    override
    fun setup(){
        useCase = UseCaseClass()
    }

    @Test
    fun `test valid usecase`() {
        val testObserver = TestObserver<String>()
        useCase.getObservable(5).subscribe(testObserver)
        assertBuilder.that(testObserver.assertResult("test"))
    }

    @Test
    fun `test invalid usecase`() {
        val testObserver = TestObserver<String>()
        useCase.getObservable(4).subscribe(testObserver)
        assertBuilder.that(testObserver.assertError(InvalidParameterException::class.java))
    }

    @Test
    fun `test valid params`() {
        val isValid = useCase.validateParams(5)
        assertBuilder.that(isValid).isTrue()
    }

    @Test
    fun `test invalid params`() {
        val isValid = useCase.validateParams(4)
        assertBuilder.that(isValid).isFalse()
    }

    @Test
    fun `test nullable params`() {
        val isValid = useCase.validateParams(null)
        assertBuilder.that(isValid).isTrue()
    }


    private class UseCaseClass
        : UseCase<String, Int?>(){
        override fun registerObservable(params: Int?): Single<String> {
            return Single.just("test")
        }

        override fun validateParams(params: Int?): Boolean {
            return params == 5 || params == null
        }
    }

}