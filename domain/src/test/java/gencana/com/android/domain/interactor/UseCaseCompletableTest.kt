package gencana.com.android.domain.interactor

import gencana.com.android.domain.BaseTestClass
import gencana.com.android.domain.TestLiveDataObserver
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import gencana.com.android.domain.testObserver
import io.reactivex.Completable
import org.mockito.Mockito.`when` as whenever

/**
 * Created by Gen Cana on 30/09/2018
 */

class UseCaseCompletableTest: BaseTestClass(){

    private lateinit var useCase: UseCaseCompletableClass

    private lateinit var liveData: TestLiveDataObserver<Boolean>

    override
    fun setup(){
        useCase = UseCaseCompletableClass(Schedulers.trampoline())
    }

    @Test
    fun `test livedata values during execution`(){
        liveData = useCase.loadingLiveData.testObserver()

        useCase.execute(1)
                .subscribe()

        assertBuilder
                .that(liveData.observedValues.size)
                .isEqualTo(2)

        assertBuilder
                .that(liveData.observedValues)
                .isEqualTo(listOf(true, false))

    }

    private class UseCaseCompletableClass
    constructor(io: Scheduler)
        : UseCaseCompletable<Int>(io){

        override fun getObservable(params: Int): Completable {
            return Completable.complete()
        }

    }

}