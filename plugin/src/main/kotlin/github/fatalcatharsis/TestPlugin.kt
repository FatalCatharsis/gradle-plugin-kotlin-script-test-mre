package github.fatalcatharsis

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType
import java.io.File
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

open class TestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create<PluginExtension>("testPlugin")
        project.tasks.create("test-kts-script") {
            doLast {
                val extension = project.extensions.getByType<PluginExtension>()
                val configuration = createJvmCompilationConfigurationFromTemplate<ScriptDefinition> {  }
                val results = BasicJvmScriptingHost().eval(extension.file.get().toScriptSource(), configuration, null)
                results.reports.forEach {
                    if (it.severity > ScriptDiagnostic.Severity.DEBUG) {
                        println(" : ${it.message}" + if (it.exception == null) "" else ": ${it.exception}")
                    }
                }
            }
        }
    }
}

interface PluginExtension {
    val file : Property<File>
}

fun Project.testPlugin(init : PluginExtension.() -> Unit) {
    configure<PluginExtension>(init)
}