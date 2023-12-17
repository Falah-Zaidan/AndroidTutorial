package com.example.tutorialapplication

import com.example.tutorialapplication.api.HPService
import com.example.tutorialapplication.util.ValidCharacterData
import com.example.tutorialapplication.util.ValidSpellData
import com.example.tutorialapplication.util.serializeCharacterData
import com.example.tutorialapplication.util.serializeSpellData
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class HPServiceTest {

    private lateinit var service: HPService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HPService::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when getCharacters() is called, api must return all characters if the response is successful`() =
        runTest {

            val expectedResponse = MockResponse() //Set up the MockWebServer response
                .setResponseCode(HttpURLConnection.HTTP_OK) //200
                .setBody(ValidCharacterData.data) // set the body to our list of characters in a JSON file

            mockWebServer.enqueue(expectedResponse)

            val response = service.getCharacters()

            val characterResponse =
                serializeCharacterData(ValidCharacterData.data) //serialize characters from JSON into a list

            assert(response == characterResponse)
        }

    @Test
    fun `when getSpells() is called, api must return all spells if the response is successful`() =
        runTest {

            val expectedResponse = MockResponse() //Set up the MockWebServer response
                .setResponseCode(HttpURLConnection.HTTP_OK) //200
                .setBody(ValidSpellData.data) // set the body to our list of spells in a JSON file

            mockWebServer.enqueue(expectedResponse)

            val response = service.getSpells()

            val spellResponse =
                serializeSpellData(ValidSpellData.data) //serialize characters from JSON into a list

            assert(response == spellResponse)
        }

}

