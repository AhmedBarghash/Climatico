pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Climatico"
include(":app")
include(":core:common")
include(":core:core-data")
include(":core:core-domain")
include(":base-android")
include(":features:cities-module:city-ui")
include(":features:cities-module:city-data")
include(":features:cities-module:city-domain")
include(":features:weather-module:selected-city-weather-broadcast-data")
include(":features:weather-module:selected-city-weather-broadcast-domain")
include(":features:weather-module:selected-city-weather-broadcast-ui")
include(":features:weather-history-module:historical-broadcast-data")
include(":features:weather-history-module:historical-broadcast-domain")
include(":features:weather-history-module:historical-broadcast-ui")
include(":features:models")
include(":models")
