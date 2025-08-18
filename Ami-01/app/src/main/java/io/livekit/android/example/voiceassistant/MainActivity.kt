package io.livekit.android.example.voiceassistant

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.livekit.android.LiveKit
import io.livekit.android.example.voiceassistant.screen.ConnectRoute
import io.livekit.android.example.voiceassistant.screen.ConnectScreen
import io.livekit.android.example.voiceassistant.screen.VoiceAssistantRoute
import io.livekit.android.example.voiceassistant.screen.VoiceAssistantScreen
import io.livekit.android.example.voiceassistant.ui.theme.LiveKitVoiceAssistantExampleTheme
import io.livekit.android.example.voiceassistant.viewmodel.VoiceAssistantViewModel
import io.livekit.android.util.LoggingLevel

class MainActivity : ComponentActivity() {

    // 🔗 Replace with your actual LiveKit server URL & token
    private val livekitUrl = "wss://ami-bhld2y0f.livekit.cloud"
    private val livekitToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NTU1MTc3MTEsImlkZW50aXR5IjoidGVzdF91c2VyIiwiaXNzIjoiQVBJWENMakY0OEU2d2JNIiwibmFtZSI6InRlc3RfdXNlciIsIm5iZiI6MTc1NTQzMTMxMSwic3ViIjoidGVzdF91c2VyIiwidmlkZW8iOnsicm9vbSI6InRlc3Rfcm9vbSIsInJvb21Kb2luIjp0cnVlfX0.nngGxxPwKQjam5nV5QMK2M0si7FulxAKL8MPaiKiTDs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LiveKit.loggingLevel = LoggingLevel.DEBUG

        // Launcher for requesting permissions
        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                val cameraGranted = permissions[Manifest.permission.CAMERA] ?: false
                val audioGranted = permissions[Manifest.permission.RECORD_AUDIO] ?: false
                if (!cameraGranted || !audioGranted) {
                    // Handle permission denial (show dialog/snackbar if needed)
                }
            }

        // Check and request permissions
        fun requestPermissionsIfNeeded() {
            val cameraPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            val audioPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)

            if (cameraPermission != PackageManager.PERMISSION_GRANTED ||
                audioPermission != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO
                    )
                )
            }
        }

        requestPermissionsIfNeeded()

        setContent {
            val navController = rememberNavController()
            LiveKitVoiceAssistantExampleTheme(dynamicColor = false) {
                Scaffold { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController, startDestination = ConnectRoute) {
                            // ✅ ConnectScreen route
                            composable<ConnectRoute> {
                                ConnectScreen { _, _ ->
                                    runOnUiThread {
                                        navController.navigate(
                                            VoiceAssistantRoute(livekitUrl, livekitToken)
                                        )
                                    }
                                }
                            }

                            // ✅ VoiceAssistantScreen route
                            composable<VoiceAssistantRoute> {
                                val viewModel = viewModel<VoiceAssistantViewModel>()
                                VoiceAssistantScreen(
                                    viewModel = viewModel,
                                    onEndCall = {
                                        runOnUiThread { navController.navigateUp() }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
