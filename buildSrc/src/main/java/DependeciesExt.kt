import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.dependencyInjection() {
    add(
        configurationName = "implementation",
        dependencyNotation = Libraries.hilt
    )
    add(
        configurationName = "kapt",
        dependencyNotation = Libraries.hiltCompiler
    )
}