plugins {
    `kotlin-dsl`
}

group = "github.fatalcatharsis"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin:kotlin-scripting-common")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm")
    implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host")
    implementation("github.fatalcatharsis:script-definition")
}

gradlePlugin {
    plugins {
        create("testPlugin") {
            id = "github.fatalcatharsis.test-plugin"
            implementationClass = "github.fatalcatharsis.TestPlugin"
        }
    }
}