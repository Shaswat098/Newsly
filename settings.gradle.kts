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
        google{
            content {
                excludeGroup("com.google.devtools.ksp") // Exclude KSP from Google Maven
            }
        }
        mavenCentral()
    }
}

rootProject.name = "Newsly"
include(":app")
 