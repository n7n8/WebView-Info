# WebView Info

一个极简 Android App：只读取并显示当前设备的 **Webview Implementation** 和 **Webview Version** 两行信息。

## 功能

- **Webview Implementation**：当前 WebView 提供者的包名（例如 `com.google.android.webview`，也可能是 `com.android.webview` 或 `com.android.chrome`）。
- **Webview Version**：版本号，格式为 `versionName(versionCode)`，例如 `157.0.8103.38(810303803)`。

实现原理：调用 `android.webkit.WebView.getCurrentWebViewPackage()`（API 26+），从返回的 `PackageInfo` 中读取：

- `packageName` → Implementation
- `versionName` + `versionCode` → Version

## 环境要求

- Android Studio（Hedgehog 或更新版本，内含 JDK 17）
- `minSdk 26`（Android 8.0），`compileSdk / targetSdk 35`
- Kotlin 2.0.21 + AGP 8.7.3 + Gradle 8.9

## 构建步骤

1. 用 Android Studio 打开本目录（`WebViewInfo`）。
2. 等待 Gradle Sync 完成（首次会自动下载 Gradle 与依赖）。
3. 连接真机或启动模拟器，点击 **Run ▶** 运行即可。

也可以在命令行构建：

```bash
./gradlew assembleDebug
# Windows: gradlew.bat assembleDebug
```

生成的 APK 位于 `app/build/outputs/apk/debug/app-debug.apk`。

## 说明

- 如果 `gradlew` / `gradlew.bat` 脚本与 `gradle-wrapper.jar` 缺失（本项目为纯文本分发时可能如此），直接用 Android Studio 打开即可，Studio 会自动补齐 Gradle Wrapper；或在命令行执行一次 `gradle wrapper --gradle-version 8.9` 生成。
- 少数设备若返回 `N/A`，说明该设备未安装任何 WebView 提供者（非常罕见）。
