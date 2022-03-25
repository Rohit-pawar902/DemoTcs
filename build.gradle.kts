

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    val sqlDelightVersion: String by project
    val kotlinVersion = "1.5.21"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

//
//sqldelight {
//    PersonDB{ // This will be the name of the generated database class.
//        packageName = "com.example.demotcs"
//    }
//}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}