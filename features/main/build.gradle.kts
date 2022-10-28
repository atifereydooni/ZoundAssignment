import com.zoundindustries.assignment.implementation

plugins {
    id(Plugins.library)
    id(Plugins.zoundPlugin)
    id(Plugins.composePlugin)
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.zoundindustries.main.TestAppJUnitRunner"
    }
}

dependencies {
    implementation(project(Modules.themeModule))

    implementation(Dependencies.retrofit)
    implementation(Dependencies.interceptor)
    api(Dependencies.converter)
    api(Dependencies.moshi)
    kapt(Dependencies.moshi_kapt)

    implementation(Dependencies.composeSwipeRefresh)

    implementation(Dependencies.composeCoil)

    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.coreTesting)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTest)

    kaptAndroidTest(Dependencies.hiltCompiler)
    androidTestImplementation(Dependencies.hiltAndroidTest)
    androidTestImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.composeTest)
    androidTestImplementation(Dependencies.coreTesting)
}