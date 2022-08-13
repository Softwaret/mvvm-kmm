pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "BooksApp"
include(":app")
include(":shared")
include(":shared:api")
include(":mvvm")
