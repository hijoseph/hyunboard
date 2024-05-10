plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.fastcampus"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
//    implementation ("org.springdoc:springdoc-openapi-ui:1.6.12")
//    implementation ("org.springdoc:springdoc-openapi-data-rest:1.6.12")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	implementation ("org.springdoc:springdoc-openapi-starter-common:2.3.0")
	implementation ("org.springframework.boot:spring-boot-starter-actuator")
	implementation ("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springframework.boot:spring-boot-starter-data-rest")
	implementation ("org.springframework.data:spring-data-rest-hal-explorer")
	/*    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation ("org.springframework.boot:spring-boot-starter-oauth2-client")
        implementation ("org.springframework.boot:spring-boot-starter-security")*/
//    implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
	/*    implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")*/
	runtimeOnly ("com.h2database:h2")
	//runtimeOnly ("mysql:mysql-connector-java")  /////
	runtimeOnly ("com.mysql:mysql-connector-j")
	runtimeOnly ("org.postgresql:postgresql")
	compileOnly ("org.projectlombok:lombok")
	developmentOnly ("org.springframework.boot:spring-boot-devtools")
	annotationProcessor ("org.projectlombok:lombok")
	annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor ("com.github.therapi:therapi-runtime-javadoc-scribe:0.15.0")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("org.springframework.security:spring-security-test")

	// query DSL 설정
//    implementation ("com.querydsl:querydsl-jpa")
	implementation ("com.querydsl:querydsl-jpa:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
	implementation ("com.querydsl:querydsl-core")
	implementation ("com.querydsl:querydsl-collections")
//    annotationProcessor ("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jpa") // querydsl JPAAnnotationProcessor 사용 지정
	annotationProcessor ("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta") // querydsl JPAAnnotationProcessor 사용 지정
	annotationProcessor ("jakarta.annotation:jakarta.annotation-api") // java.lang.NoClassDefFoundError (javax.annotation.Generated) 대응 코드
	annotationProcessor ("jakarta.persistence:jakarta.persistence-api") // java.lang.NoClassDefFoundError (javax.annotation.Entity) 대응 코드

}

tasks.withType<Test> {
	useJUnitPlatform()
}
