package gencana.com.android.domain.interactor

import gencana.com.android.domain.BaseTestClass
import gencana.com.android.domain.TestLiveDataObserver
import gencana.com.android.domain.model.Movie
import gencana.com.android.domain.model.Paging
import gencana.com.android.domain.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

/**
 * Created by Gen Cana on 30/09/2018
 */

class GetMovieListInteractorTest: BaseTestClass(){

    @Mock
    private lateinit var repository: MovieRepository

    private lateinit var interactor: GetMovieListInteractor

    private  val movieListObservable = Single.just(
            Paging(1, 1, 1, listOf(Movie(1), Movie(2))))

    private lateinit var liveData: TestLiveDataObserver<Boolean>

    override fun setup() {
        interactor = GetMovieListInteractor(repository)
        `when`(repository.getMovieList(Mockito.anyInt())).thenReturn(movieListObservable)
    }

    @Test
    fun `test success getting movies`(){
        val testObserver = TestObserver<Paging<Movie>>()
        val sampleResult = 75
        val paging = Paging<Movie>(totalResults = sampleResult)
        `when`(repository.getMovieList(Mockito.anyInt())).thenReturn(Single.just(paging))
        interactor.getObservable(Mockito.anyInt())
                .subscribe(testObserver)

        assertBuilder.that(testObserver.assertValue{
            it.totalResults == sampleResult
        })
        assertBuilder.that(testObserver.assertComplete())
        verify(repository).getMovieList(Mockito.anyInt())
        verifyNoMoreInteractions(repository)
    }

    @Test
    fun `sucess on valid params`(){
        interactor.getObservable(5)
        verify(repository).getMovieList(Mockito.anyInt())
        verifyNoMoreInteractions(repository)
    }


}