package com.example.slider

// Import necessary classes for HTTP client and Retrofit library.
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object to manage API client setup and communication.
object ApiClient {
    // Variables to store username and password for Basic Authentication.
    private var username: String = "" // Stores the username provided by the user.
    private var password: String = "" // Stores the password provided by the user.

    // Custom OkHttpClient instance with an interceptor for adding authentication headers.
    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor { chain ->
                // Intercept the request and add Basic Authentication headers.
                val request = chain.request().newBuilder()
                    .header("Authorization", okhttp3.Credentials.basic(username, password)) // Add Authorization header.
                    .build()
                chain.proceed(request) // Proceed with the modified request.
            }
            .build()

    // Retrofit instance configured with the base URL and custom client.
    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/Slider/") // Set the base URL for the API.
            .client(client) // Attach the custom OkHttpClient with authentication.
            .addConverterFactory(GsonConverterFactory.create()) // Add a converter to handle JSON serialization and deserialization.
            .build()

    // Method to update the credentials for API requests.
    fun setCredentials(user: String, pass: String) {
        username = user // Update the username.
        password = pass // Update the password.
    }

    // Property to get an instance of the SliderApi interface.
    val sliderApi: SliderApi
        get() = retrofit.create(SliderApi::class.java) // Create and return the API service instance.
}
