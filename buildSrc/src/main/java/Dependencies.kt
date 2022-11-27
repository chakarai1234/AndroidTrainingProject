object Versions {
    const val core_ktx_version = "1.9.0"
    const val appcompat_version = "1.5.1"
    const val material_version = "1.7.0"
}

object Deps {
    val core_ktx_deps by lazy { "androidx.core:core-ktx:${Versions.core_ktx_version}" }
    val appcompat_deps by lazy { "androidx.appcompat:appcompat:${Versions.appcompat_version}" }
    val material_deps by lazy { "com.google.android.material:material:${Versions.material_version}" }
}
