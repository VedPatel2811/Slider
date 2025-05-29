package com.example.slider

// Import necessary Android and Compose libraries.
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// MainActivity: Entry point of the application, managing UI and app state.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up the UI content using Jetpack Compose.
        setContent {
            MaterialTheme {
                // State variables for managing the app's data and UI behavior.
                var username by remember { mutableStateOf("") } // Stores the entered username.
                var password by remember { mutableStateOf("") } // Stores the entered password.
                var sliders by remember { mutableStateOf<List<Slider>?>(null) } // Holds the list of sliders fetched from the API.
                var showLoginDialog by remember { mutableStateOf(true) } // Controls the visibility of the login dialog.

                // Show login dialog if the user hasn't logged in yet.
                if (showLoginDialog) {
                    LoginDialog(
                        onLogin = { user, pass -> // Callback triggered when the user submits the login form.
                            username = user // Store the entered username.
                            password = pass // Store the entered password.
                            ApiClient.setCredentials(user, pass) // Set the credentials for API authentication.
                            showLoginDialog = false // Close the login dialog.

                            // Fetch slider data from the API after successful login.
                            ApiClient.sliderApi.getSliders().enqueue(object : Callback<List<Slider>> {
                                override fun onResponse(call: Call<List<Slider>>, response: Response<List<Slider>>) {
                                    if (response.isSuccessful) {
                                        sliders = response.body() // Update the sliders list with the response data.
                                    } else {
                                        // Show a message if the API call fails.
                                        Toast.makeText(this@MainActivity, "Failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                override fun onFailure(call: Call<List<Slider>>, t: Throwable) {
                                    // Show a message if there is an error in the API call.
                                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                                }
                            })
                        },
                        onCancel = { finish() } // Close the app if the user cancels the login dialog.
                    )
                }

                // Main scaffold for the app's UI, providing a consistent layout structure.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Content inside the scaffold.
                    Column(Modifier.padding(innerPadding)) {
                        // Check if sliders data is available.
                        if (sliders != null) {
                            // Header row for the slider attributes.
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp), // Add padding around the row.
                                horizontalArrangement = Arrangement.SpaceBetween // Distribute items evenly across the row.
                            ) {
                                // Headers for each slider attribute.
                                Text("Id", Modifier.weight(1f), fontWeight = FontWeight.Bold)
                                Text("Size", Modifier.weight(1f), fontWeight = FontWeight.Bold)
                                Text("X", Modifier.weight(1f), fontWeight = FontWeight.Bold)
                                Text("Y", Modifier.weight(1f), fontWeight = FontWeight.Bold)
                                Text("MaxTravel", Modifier.weight(2f), fontWeight = FontWeight.Bold)
                                Text("CurrentTravel", Modifier.weight(2f), fontWeight = FontWeight.Bold)
                                Text("MvtDirection", Modifier.weight(2f), fontWeight = FontWeight.Bold)
                                Text("DirChangeCount", Modifier.weight(2f), fontWeight = FontWeight.Bold)
                            }

                            // LazyColumn for displaying the slider data as a scrollable list.
                            LazyColumn {
                                // Loop through the sliders list and display each slider in a row.
                                items(sliders!!) { slider ->
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp), // Add padding around each row.
                                        horizontalArrangement = Arrangement.SpaceBetween // Distribute items evenly across the row.
                                    ) {
                                        // Display each attribute of the slider object.
                                        Text("${slider.id}", Modifier.weight(1f))
                                        Text("${slider.size}", Modifier.weight(1f))
                                        Text("${slider.x}", Modifier.weight(1f))
                                        Text("${slider.y}", Modifier.weight(1f))
                                        Text("${slider.maxTravel}", Modifier.weight(2f))
                                        Text("${slider.currentTravel}", Modifier.weight(2f))
                                        Text("${slider.mvtDirection}", Modifier.weight(2f))
                                        Text("${slider.dirChangeCount}", Modifier.weight(2f))
                                    }
                                }
                            }
                        } else {
                            // Show a message while the sliders data is being fetched.
                            Text("Loading sliders...")
                        }
                    }
                }
            }
        }
    }
}

// Composable function for displaying a login dialog box.
@Composable
fun LoginDialog(onLogin: (String, String) -> Unit, onCancel: () -> Unit) {
    // State variables for the input fields.
    var username by remember { mutableStateOf("") } // Stores the entered username.
    var password by remember { mutableStateOf("") } // Stores the entered password.

    // AlertDialog for user login.
    AlertDialog(
        onDismissRequest = { }, // Prevent dismissing the dialog by tapping outside.
        title = { Text("Login") }, // Dialog title.
        text = {
            // Content of the dialog: Input fields for username and password.
            Column {
                // Input field for username.
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it }, // Update the username as the user types.
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth() // Make the text field take up the full width.
                )
                // Input field for password.
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it }, // Update the password as the user types.
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth() // Make the text field take up the full width.
                )
            }
        },
        confirmButton = {
            // Button for submitting the login form.
            Button(onClick = { onLogin(username, password) }) {
                Text("Login") // Button label.
            }
        },
        dismissButton = {
            // Button for canceling the login process.
            Button(onClick = { onCancel() }) {
                Text("Cancel") // Button label.
            }
        }
    )
}
