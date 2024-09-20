plugins {
    id("java")
}

group = "org.rmartin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 API
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    // JUnit 5 Engine (zum Ausführen der Tests)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    // Gson für JSON-Verarbeitung
    implementation("com.google.code.gson:gson:2.8.9")
}

tasks.test {
    useJUnitPlatform()
}