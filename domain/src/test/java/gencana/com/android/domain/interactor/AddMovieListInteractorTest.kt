package gencana.com.android.domain.interactor

import gencana.com.android.domain.BaseTestClass
import gencana.com.android.domain.TestLiveDataObserver
import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.repository.MovieRepository
import gencana.com.android.domain.testObserver
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`


/**
 * Created by Gen Cana on 30/09/2018
 */

class AddMovieListInteractorTest: BaseTestClass(){

    @Mock
    private lateinit var repository: MovieRepository

    private lateinit var interactor: AddMovieListInteractor



    private  val movieList = listOf(Movie(1), Movie(2))

    private lateinit var liveData: TestLiveDataObserver<Boolean>

    override fun setup() {
        interactor = AddMovieListInteractor(repository, Schedulers.trampoline())
        liveData = interactor.loadingLiveData.testObserver()
    }

    @Test
    fun `test success adding movies`(){
        `when`(repository.insertMovieList(movieList)).thenReturn(Completable.complete())
        interactor.execute(movieList)
                .subscribe()
        Mockito.verify(repository).insertMovieList(movieList)
        Mockito.verifyNoMoreInteractions(repository)

        assertBuilder
                .that(liveData.observedValues.size)
                .isEqualTo(2)

        assertBuilder
                .that(liveData.observedValues)
                .isEqualTo(listOf(true, false))
    }

    @Test
    fun `sucess on valid params`(){
        interactor.getObservable(movieList)
        Mockito.verify(repository).insertMovieList(movieList)
        Mockito.verifyNoMoreInteractions(repository)
    }

}