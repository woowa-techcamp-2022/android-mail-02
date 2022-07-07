buildscript {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath(libs.plugin.androidGradle)
        classpath(libs.plugin.kotlin)
        classpath(libs.plugin.hilt)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    afterEvaluate {
        project.apply("$rootDir/gradle/common.gradle")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
