apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.common))
    "implementation"(project(Modules.searchDomain))

    "implementation"(Coroutines.coroutines)

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)

    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
    "implementation"(Room.roomPaging)

    "implementation"(Compose.paging)
}