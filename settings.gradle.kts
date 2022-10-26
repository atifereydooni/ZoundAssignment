dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}
rootProject.name = ("ZoundAssignment")
include(
    ":app",
    ":core:theme",
    ":core:navigation",
    ":features:main",
)
