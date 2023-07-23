plugins {
    id("org.jetbrains.kotlin.jvm").version("1.8.20")
    id("github.fatalcatharsis.test-plugin")
}

group = "github.fatalcatharsis"

testPlugin {
    file.set(projectDir.resolve("example.test.kts"))
}


dependencies {
    //implementation("github.fatalcatharsis:script-definition")
}

repositories {
    mavenCentral()
}