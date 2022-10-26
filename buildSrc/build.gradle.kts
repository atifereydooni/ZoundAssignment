plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
}

gradlePlugin {
    val packageName = "com.zoundindustries.assignment"
    plugins {
        register("zound.plugin") {
            id = "zound.plugin"
            implementationClass = "$packageName.ZoundPlugin"
        }

        register("compose.plugin") {
            id = "compose.plugin"
            implementationClass = "$packageName.ComposePlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
}
