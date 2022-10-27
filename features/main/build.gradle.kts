import com.zoundindustries.assignment.implementation

plugins {
    id(Plugins.library)
    id(Plugins.zoundPlugin)
    id(Plugins.composePlugin)
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
}