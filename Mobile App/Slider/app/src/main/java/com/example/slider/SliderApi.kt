package com.example.slider

// Import Retrofit library components for network communication.
import retrofit2.Call
import retrofit2.http.GET

// Data class representing the Slider object.
// This class defines the structure of a Slider entity as retrieved from the API.
data class Slider(
    val currentTravel: Int, // Current travel distance of the slider.
    val dirChangeCount: Int, // Number of times the slider has changed direction.
    val id: Int, // Unique identifier for the slider.
    val maxTravel: Int, // Maximum travel distance allowed for the slider.
    val mvtDirection: Int, // Current movement direction of the slider (e.g., 1 for right, -1 for left).
    val size: Int, // Size of the slider.
    val x: Int, // Current x-coordinate of the slider.
    val y: Int // Current y-coordinate of the slider.
)

// Interface defining the Retrofit API for interacting with Slider resources.
// Retrofit automatically handles the creation of this API service based on the interface definition.
interface SliderApi {
    // GET request to fetch a list of Slider entities.
    // The endpoint "resources/cst8218.slider.entity.slider" is relative to the base URL defined in ApiClient.
    @GET("resources/cst8218.slider.entity.slider")
    fun getSliders(): Call<List<Slider>> // Returns a Call object that asynchronously fetches a list of Slider objects.
}
