import org.gradle.kotlin.dsl.version
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.jetbrains.kotlin.jvm") version "1.2.61"
	id("io.spring.dependency-management") version "1.0.5.RELEASE"
	id("org.springframework.boot") version "2.1.0.M1"
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.fu:spring-fu-dependencies:0.0.1.BUILD-SNAPSHOT")
	}
}

dependencies {
	implementation("org.springframework.fu.module:spring-fu-logging-logback")
	implementation("org.springframework.fu.module:spring-fu-webflux-netty")
	testImplementation("org.springframework.fu.module:spring-fu-test")
}

repositories {
	mavenCentral()
	maven("https://repo.spring.io/libs-milestone")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=enable")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
