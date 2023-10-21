package com.example.tutorialapplication

import com.example.tutorialapplication.api.HPService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.HttpURLConnection

class ServiceTest {

    val mockWebServer = MockWebServer()
    lateinit var myService: HPService

    @Before
    fun setUp() {
        mockWebServer.start()
        myService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HPService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `when getCharacters() called, return a list of characters`() = runTest {

        val expectedResponse = MockResponse() //Set up the MockWebServer response
            .setResponseCode(HttpURLConnection.HTTP_OK) //200
            .setBody(CharacterData.data) // set the body to our list of characters in a JSON file

        mockWebServer.enqueue(expectedResponse)

        val characterResponse = myService.getCharacters()
        val listOfCharacters = serializeCharacterData(CharacterData.data)

        assert(characterResponse == listOfCharacters)

    }

}