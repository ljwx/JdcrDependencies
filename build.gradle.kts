plugins {
    `version-catalog`
    `maven-publish`
}

group = "com.github.ljwx"
version = "0.3.0" // 每次你更新了版本号，就要把这个加 1

// 配置你要发布的 Catalog 内容
catalog {
    versionCatalog {
        // --- 1. 定义版本号 ---
        version("ktor", "2.3.5")
        version("coroutines", "1.7.3")
        version("compose", "1.5.0")
        
        // --- 2. 定义依赖 ---
        library("ktor-core", "io.ktor", "ktor-client-core").versionRef("ktor")
        library("coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")
        
        // --- 3. 定义插件 (非常重要！比如你现在图上的 alias(libs.plugins.xxx)) ---
        plugin("androidApplication", "com.android.application").version("8.1.1")
        plugin("kotlinMultiplatform", "org.jetbrains.kotlin.multiplatform").version("1.9.10")
    }
}

// 声明一个给 JitPack 打包用的产物发布通道
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
