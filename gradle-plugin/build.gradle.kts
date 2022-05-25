plugins {
    `java-gradle-plugin`
    kotlin("jvm")
    groovy
}

repositories {
    mavenCentral()
}

sourceSets {
    val main by getting {
        java {
            srcDir(".")
            exclude("build.gradle.kts")
        }
    }
    val test by getting {
        groovy {
            srcDir("test")
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(gradleTestKit())
    testImplementation(libs.spock)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    javaPackagePrefix = "io.github.singleton11.speedway.gradle"
}

gradlePlugin {
    plugins {
        create("SpeedwayGradlePlugin") {
            id = "io.github.singleton11.speedway.gradle"
            implementationClass = "io.github.singleton11.speedway.gradle.SpeedwayConfigurationSettingsPlugin"
        }
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}