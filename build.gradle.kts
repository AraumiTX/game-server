import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.8.0"
  distribution
  application
}

group = "jp.assasans.araumi.tx.server"
version = "0.1.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("reflect"))

  /* Networking */
  implementation("io.ktor:ktor-server-core:2.1.0")
  implementation("io.ktor:ktor-network:2.1.0")
  implementation("io.ktor:ktor-server-netty:2.1.0")
  implementation("io.ktor:ktor-server-call-logging:2.1.0")
  implementation("io.ktor:ktor-server-content-negotiation:2.1.0")

  /* Serialization */
  implementation("com.squareup.moshi:moshi:1.13.0")
  implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
  implementation("com.squareup.moshi:moshi-adapters:1.13.0")

  implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")

  implementation("javax.xml.bind:jaxb-api:2.3.1")
  implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

  /* Database */

  /* Inversion of Control */
  implementation("io.insert-koin:koin-core:3.2.0")
  implementation("io.insert-koin:koin-logger-slf4j:3.2.0")

  testImplementation("io.insert-koin:koin-test:3.2.0")
  testImplementation("io.insert-koin:koin-test-junit5:3.2.0")

  /* Utilities */
  implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

  implementation("org.reflections:reflections:0.10.2")

  implementation("org.apache.commons:commons-compress:1.22")

  implementation("com.github.seancfoley:ipaddress:5.3.4")

  implementation("com.github.ajalt.clikt:clikt:3.5.0")

  /* Logging */
  implementation("ch.qos.logback:logback-classic:1.4.0")
  implementation("io.github.microutils:kotlin-logging:2.1.23")

  /* Testing */
  testImplementation(kotlin("test"))
}

configurations {
  testImplementation.get().exclude("org.jetbrains.kotlin", "kotlin-test-junit")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.ExperimentalStdlibApi"
  kotlinOptions.jvmTarget = "17"
}

sourceSets {
  main {
    resources {
      exclude("data")
      exclude("import")
    }
  }
}

distributions {
  all {
    contents {
      from("src/main/resources/data") { into("data") }
      from("src/main/resources/import") { into("import") }
    }
  }
}

tasks {
  wrapper {
    gradleVersion = "7.4.2"
    distributionType = Wrapper.DistributionType.BIN
  }

  jar {
    archiveBaseName.set("araumi-game-server")
    archiveVersion.set("${project.version}")

    manifest {
      attributes["Main-Class"] = application.mainClass
      attributes["Implementation-Version"] = "${project.version}"
    }

    dependsOn("copyDependencies")
    dependsOn("copyRuntimeResources")
    dependsOn("copyDatabaseImports")
  }

  register<Sync>("copyRuntimeResources") {
    // Copy runtime resources to the jar directory
    from("$projectDir/src/main/resources/data")
    into("$buildDir/data")
  }

  register<Sync>("copyDatabaseImports") {
    from("$projectDir/src/main/resources/import")
    into("$buildDir/import")
  }

  register<Sync>("copyDependencies") {
    from(configurations.default)
    into("$buildDir/dependencies")
  }

  test {
    useJUnitPlatform()
  }

  startScripts {
    doLast {
      // Fix script not running in cmd because of too long line
      val script = windowsScript
        .readText()
        .replace(Regex("set CLASSPATH=.*"), "set CLASSPATH=%APP_HOME%/lib/*")
      windowsScript.writeText(script)
    }
  }
}

application {
  mainClass.set("jp.assasans.araumi.tx.server.MainKt")
}
