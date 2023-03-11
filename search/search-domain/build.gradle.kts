apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.common))

    "implementation"(Coroutines.coroutines)
    "implementation"(Compose.paging)
}