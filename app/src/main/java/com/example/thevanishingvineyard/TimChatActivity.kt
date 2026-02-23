package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class TimChatActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tim_chat)

        val webView = findViewById<WebView>(R.id.webview)
        webView.webViewClient = WebViewClient()  // Ensures links open within the WebView

        // Enable JavaScript and other settings for better compatibility
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccess = true
        webSettings.allowContentAccess = true
        webSettings.domStorageEnabled = true  // Enable DOM storage API
        webSettings.loadWithOverviewMode = true  // Makes the WebView fit the content width
        webSettings.useWideViewPort = true  // Adjusts to screen size

        // Load the HTML file
        webView.loadUrl("file:///android_asset/timchat.html")
    }
}
