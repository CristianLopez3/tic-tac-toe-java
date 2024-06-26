plugins {
    id("java")
    id("application")

}

group = "com.game"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:4.2.0")
    testImplementation("org.mockito:mockito-junit-jupiter:4.2.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.game.Main")
}

tasks.named("jar") {
    enabled = true
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.game.Main"
    }
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") })
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com.game.Main"
    }
}