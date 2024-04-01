plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    java
    `maven-publish`
}

group = "de.chojo"
version = "1.6.3"

repositories {
    maven("https://eldonexus.de/repository/maven-public")
    maven("https://eldonexus.de/repository/maven-proxies")
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    // discord
    implementation("net.dv8tion", "JDA", "5.0.0-alpha.5") {
        exclude(module = "opus-java")
    }

    implementation("de.chojo", "cjda-util", "2.1.1c+alpha.9-DEV")

    // database
    implementation("org.postgresql", "postgresql", "42.3.3")
    implementation("com.zaxxer", "HikariCP", "5.0.1")

    // Serialization
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.13.2")

    // Logging
    implementation("org.slf4j", "slf4j-api", "1.7.36")
    implementation("org.apache.logging.log4j", "log4j-core", "2.17.2")
    implementation("org.apache.logging.log4j", "log4j-slf4j-impl", "2.17.2")
    implementation("club.minnced", "discord-webhooks", "0.8.0")

    // utils
    implementation("org.apache.commons", "commons-lang3", "3.12.0")
    implementation("de.chojo", "sql-util", "1.2.0")
    implementation("com.google.guava","guava","31.1-jre")

    // unit testing
    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
}


java {
    withSourcesJar()
    withJavadocJar()

    sourceCompatibility = JavaVersion.VERSION_15
}

tasks {
    processResources {
        from(sourceSets.main.get().resources.srcDirs) {
            filesMatching("version") {
                expand(
                    "version" to project.version
                )
            }
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    javadoc {
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    shadowJar{
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "de.chojo.repbot.ReputationBot"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}
