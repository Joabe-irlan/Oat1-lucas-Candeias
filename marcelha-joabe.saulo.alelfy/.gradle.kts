plugins {
    // Aplica o plugin do Kotlin para JVM
    kotlin("jvm") version "1.9.22"
    
    // Plugin opcional para facilitar a criação de um executável (Jar)
    application
}

group = "com.seuprojeto"
version = "1.0-SNAPSHOT"

repositories {
    // Onde o Gradle busca as bibliotecas (Maven Central é o padrão)
    mavenCentral()
}

dependencies {
    // Biblioteca padrão do Kotlin
    implementation(kotlin("stdlib"))

    // Framework de Testes: JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    
    // Opcional: Biblioteca para asserções mais "fluentes" nos testes
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
}

tasks.test {
    // Configura o Gradle para usar a plataforma do JUnit 5
    useJUnitPlatform()
    
    // Mostra o resultado dos testes no console enquanto rodam
    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    // Define a versão do Java compatível (ex: Java 11 ou 17)
    jvmToolchain(17)
}

application {
    // Se o seu projeto tiver uma função main, defina o caminho aqui
    mainClass.set("MainKt")
}
