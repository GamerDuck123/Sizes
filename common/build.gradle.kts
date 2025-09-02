dependencies {
    compileOnly(libs.gson)
    compileOnly(libs.configurate)

    testImplementation(libs.configurate)
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    assemble {
//        dependsOn(shadowJar)
        doLast {
            delete(fileTree(baseDir = "$buildDir").include("**/*-dev*.jar"))
        }
    }

    test {
        useJUnitPlatform()
    }

//    shadowJar {
//        archiveBaseName.set("${rootProject.name}-${project.name}")
//        archiveClassifier.set("")
//        mergeServiceFiles()

//        listOf(
//            "net.kyori",
//            "org.bstats",
//            "org.simpleyaml",
//            "org.yaml.snakeyaml"
//        ).forEach {
//            relocate(it, "libs.$it")
//        }
//    }
}