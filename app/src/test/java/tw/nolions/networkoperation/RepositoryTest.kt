package tw.nolions.networkoperation

import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    var testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Repository.baseAPI("https://httpbin.org")
    }

    @Test
    fun getTest() {


    }
}