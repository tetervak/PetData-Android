// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false

    // needed for the dependency injection
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
}