plugins {
    id("org.jetbrains.kotlin.jvm").version("1.8.20")
    id("java-gradle-plugin")
}

group = "github.fatalcatharsis"

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin:kotlin-scripting-common")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host")
    implementation("org.jetbrains.kotlin:kotlin-scripting-common")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies")
    implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies-maven")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlin:kotlin-test")
}

gradlePlugin {
    plugins {
        create("testPlugin") {
            id = "github.fatalcatharsis.test-plugin"
            implementationClass = "github.fatalcatharsis.TestPlugin"
        }
    }
}