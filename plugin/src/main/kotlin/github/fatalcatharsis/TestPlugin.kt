package github.fatalcatharsis

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import java.io.File
import kotlin.script.experimental.api.KotlinType
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.host.createCompilationConfigurationFromTemplate
import kotlin.script.experimental.host.createEvaluationConfigurationFromTemplate
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.host.withDefaultsFrom
import kotlin.script.experimental.jvm.defaultJvmScriptingHostConfiguration
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

open class TestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("testPlugin", PluginExtension::class.java)

        project.tasks.create("test-kts-script") {
            it.doLast {
                val extension = project.extensions.getByType(PluginExtension::class.java)
                //val configuration = createJvmCompilationConfigurationFromTemplate<ScriptDefinition> {  }
                val configuration = createCompilationConfigurationFromTemplate(
                    KotlinType(ScriptDefinition::class),
                    null.withDefaultsFrom(defaultJvmScriptingHostConfiguration),
                    ScriptDefinition::class
                )

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

