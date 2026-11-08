package com.example.webviewinfo

import android.content.pm.PackageInfo
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val implementationView = findViewById<TextView>(R.id.tvWebViewImplementation)
        val versionView = findViewById<TextView>(R.id.tvWebViewVersion)

        val packageInfo: PackageInfo? = WebView.getCurrentWebViewPackage()

        if (packageInfo != null) {
            implementationView.text = packageInfo.packageName
            versionView.text = buildVersionString(packageInfo)
        } else {
            implementationView.text = getString(R.string.not_available)
            versionView.text = getString(R.string.not_available)
        }
    }

    /**
     * Builds the version string in the form "versionName(versionCode)",
     * e.g. "157.0.8103.38(810303803)".
     */
    private fun buildVersionString(packageInfo: PackageInfo): String {
        val versionName = packageInfo.versionName ?: ""
        val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo.longVersionCode
        } else {
            @Suppress("DEPRECATION")
            packageInfo.versionCode.toLong()
        }
        return "$versionName($versionCode)"
    }
}
