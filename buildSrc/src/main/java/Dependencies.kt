object Modules {
    const val app = ":app"
    const val domain = ":api:domain"
    const val navigator = ":navigator"
    const val foundation = ":foundation"
    const val model = ":api:model"
    const val remote = ":api:remote"
    const val carousell = ":carousell"
}

object Versions {
    const val nav_version = "2.7.5"
    const val hilt_version = "2.49"
    const val retrofit_version = "2.9.0"
    const val data_store_version = "1.0.0"
    const val room_version = "2.5.1"
    const val chucker_version = "4.0.0"
    const val compose_compiler_version = "1.5.4"
    const val kotlin_version = "1.8.20"
    const val core_version = "1.12.0"
    const val composeCoil = "2.4.0"
    const val lottie = "6.1.0"
}

object Libraries {
    // navigation
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"

    // hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt_version}"

    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofitConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"

    // datastore
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.data_store_version}"

    // room
    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room_version}"

    // chucker
    const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker_version}"
    const val chuckerRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker_version}"

    // compose
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUi = "androidx.compose.ui:ui"
    const val compose = "androidx.compose:compose-bom:2023.01.00"
    const val composeMaterial = "androidx.compose.material3:material3"
    const val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    const val coil = "io.coil-kt:coil-compose:${Versions.composeCoil}"

    // core
    const val core = "androidx.core:core-ktx:${Versions.core_version}"

    // lottie
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
}