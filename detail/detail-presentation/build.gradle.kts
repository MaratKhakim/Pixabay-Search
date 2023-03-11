apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.common))
    "implementation"(project(Modules.coreUi))

    "implementation"(Coil.coilCompose)
}