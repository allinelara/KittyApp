package com.allinedelara.kittyapp

import android.os.Build
import com.allinedelara.kittyapp.di.testApp
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONArray
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.unloadKoinModules
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class ImageViewModelTest : KoinTest {

    private var mockServer: MockWebServer = MockWebServer()

    @Before
    fun before() {
        startKoin {
            modules(testApp)
        }
        loadKoinModules(testApp)
        mockServer.start(8080)
    }


    @After
    fun after() {
        unloadKoinModules(testApp)
        stopKoin()
        mockServer.shutdown()
    }

    @Test
    fun getImages() = runBlocking {
        val mockResponse = getMockJsonAssertNull("getImages_response.json")
        val actualResponse = MockApi().getAll(100, urls = true, httpsUrls = true)

        assertNotNull(actualResponse)

        assertNotNull(actualResponse[0])

        val expected = JSONArray(mockResponse)
        val data = JSONArray(Gson().toJson(actualResponse))

        assertEquals(data.get(0), expected.get(0))

    }
    private fun getMockJsonAssertNull(jsonString: String): String {
        val mockResponse = MockResponseFileReader(jsonString).content
        assertNotNull(mockResponse)
        mockServer.apply {
            enqueue(MockResponse().setBody(mockResponse))
        }
        assertNotNull(mockResponse)
        return mockResponse
    }
}
