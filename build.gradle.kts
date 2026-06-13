plugins {
    `version-catalog`
    `maven-publish`
}

group = "com.github.ljwx"
version = "0.0.1"

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
