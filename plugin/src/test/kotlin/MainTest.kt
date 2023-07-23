import github.fatalcatharsis.ScriptDefinition
import org.junit.Test
import java.io.File
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

class MainTest {
    @Test
    fun test2() {
        println("starting...")
        val configuration = createJvmCompilationConfigurationFromTemplate<ScriptDefinition> {  }
        val results = BasicJvmScriptingHost().eval(File("test.kts").toScriptSource(), configuration, null)

        println("test" + results)
    }
}