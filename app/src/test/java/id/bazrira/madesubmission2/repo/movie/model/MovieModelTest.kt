package id.bazrira.madesubmission2.repo.movie.model

import android.content.Context
import id.bazrira.madesubmission2.ui.movie.viewmodel.MovieViewModel
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieModelTest {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieModel: MovieModel

    private val dummyTotalData = 20

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        movieModel = mock(MovieModel::class.java)
        mockContext = mock(Context::class.java)

        movieViewModel = MovieViewModel(movieModel, mockContext)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        movieModel = MovieModel()
        movieViewModel = MovieViewModel(movieModel, mockContext)

        val totalData = movieViewModel.getData().size
        assertEquals(dummyTotalData, totalData)
    }
}