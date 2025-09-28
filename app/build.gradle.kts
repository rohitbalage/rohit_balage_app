plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.rrbofficial.rohitbalage"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.rrbofficial.rohitbalage"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    compileOptions {
        // Java compile target 17
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17" // matches Java target
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.drawerlayout) // DrawerLayout support
    implementation(libs.androidx.recyclerview) // RecyclerView
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.activity) // Fragment KTX

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //material design:
    implementation(libs.material) // Latest version

    // youth banner
    implementation("io.github.youth5201314:banner:2.2.2")
    // Core Glide library
    implementation("com.github.bumptech.glide:glide:4.15.1")

    //firebase libraries
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore)

    //one signal -notification
    implementation("com.onesignal:OneSignal:[5.0.0, 5.99.99]")

    // fancy toast - toast message
    implementation("io.github.shashank02051997:FancyToast:2.0.2")

    //motion toast
    implementation("com.github.Spikeysanju:MotionToast:1.4")

    //mp-chart library
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //rate bar
    implementation("com.github.hotchemi:android-rate:1.0.1")

    //asthetic dialogues
    implementation("com.github.gabriel-TheCode:AestheticDialogs:1.3.8")

    // super bottom sheet
    implementation("com.github.andrefrsousa:SuperBottomSheet:2.0.0")

    //material design
    implementation("com.google.android.material:material:1.12.0")

    //app intro
//    implementation("com.github.paolorotolo:appintro:4.1.0")



    //yo yo animation
    implementation("com.daimajia.androidanimations:library:2.4@aar")

    //fancy showcase
    implementation("com.github.faruktoptas:FancyShowCaseView:1.3.9")

    //lottie animation
    implementation("com.airbnb.android:lottie:5.2.0")

    //assertive touch button
//    implementation("com.github.mmoamenn:Assertive-Touch:1.2.0")

    //floating menu
    implementation("com.github.rjsvieira:floatingMenu:1.3.0")

    //waveview -- animation
    implementation("com.github.john990:WaveView:v0.9")

    //foldable layout -- image
    implementation("com.vincentbrison.openlibraries.android:foldablelayout:0.0.1@aar")

    //vorolay -- image collage
    implementation("com.github.Quatja:Vorolay:1.0.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp Logging Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // tap sphere view
    implementation("com.github.magic-goop:tag-sphere:1.0.0")

    implementation("uk.co.samuelwall:material-tap-target-prompt:3.3.2")

    //AWS
   implementation("com.amazonaws:aws-android-sdk-ddb:2.13.+")



    implementation("com.amazonaws:aws-android-sdk-mobile-client:2.13.+@aar") {
        isTransitive = true
    }

}

