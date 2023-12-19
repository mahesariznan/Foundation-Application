object Modules {
    const val app = ":app"
    const val domain = ":api:domain"
    const val navigator = ":navigator"
    const val foundation = ":foundation"
    const val model = ":api:model"
    const val remote = ":api:remote"
    const val featureOne = ":featureOne"
    const val featureTwo = ":featureTwo"
}

object Versions {
    const val nav_version = "2.7.5"
    const val hilt_version = "2.49"
    const val retrofit_version = "2.9.0"
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
}