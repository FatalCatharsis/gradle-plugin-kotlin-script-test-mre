import github.fatalcatharsis.testPlugin

plugins {
    id("github.fatalcatharsis.test-plugin")
}

group = "github.fatalcatharsis"
version = "1.0-SNAPSHOT"

testPlugin {
    file.set(projectDir.resolve("example.test.kts"))
}