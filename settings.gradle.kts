
rootProject.name = "kotlin-script-mre"

include("client")
includeBuild("script-definition")

pluginManagement {
    includeBuild("plugin")
}