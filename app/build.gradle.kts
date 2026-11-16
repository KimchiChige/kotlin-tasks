plugins {
    alias(libs.plugins.kotlin.jvm)

    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass = "org.example.AppKt"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

// Кодировка, в которой JVM печатает в консоль.
// Русская консоль Windows (cmd, PowerShell, терминал IntelliJ IDEA) работает в
// OEM-кодировке Cp866, а JVM по умолчанию пишет в Cp1251 (ANSI). Пока кодировки
// не совпадают, вместо «Задача 1» в терминале видно «╨Ч╨░╨┤╨░╤З╨░».
// Проверить кодировку терминала: chcp (для русского Windows — 866).
// Если терминал в другой кодировке, её можно задать явно:
//   .\gradlew.bat :app:run -Pconsole.encoding=windows-1251
val consoleEncoding = providers.gradleProperty("console.encoding").getOrElse("Cp866")

tasks.named<JavaExec>("run") {
    jvmArgs(
        "-Dfile.encoding=$consoleEncoding",
        // sun.stdout.encoding — для JDK 17, stdout.encoding — для JDK 19+
        "-Dsun.stdout.encoding=$consoleEncoding",
        "-Dstdout.encoding=$consoleEncoding",
        "-Dsun.stderr.encoding=$consoleEncoding",
        "-Dstderr.encoding=$consoleEncoding",
    )
    standardInput = System.`in`
}
