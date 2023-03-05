Notes. Разработка на Java (2018)

https://www.youtube.com/watch?v=Ok81Ue2mu0A&list=PLrCZzMib1e9pnFbVV3u4s7ki5NTnm7WgT&index=5&ab_channel=VKTeam

https://github.com/rybalkinsd/atom

https://github.com/MattSkala/html5-bombergirl


(settings.gradle)
rootProject.name = 'homework1'


(build.gradle)
repositories {
    mavenCentral()
}

apply plugin: 'java'
apply plugin: 'checkstyle'

dependencies {
    // https://mvnrepository.com/artifact/junit/junit
    // testCompile group: 'junit', name: 'junit', version: '4.4'
    testImplementation 'junit:junit:4.13.2'
}

checkstyle {
    ignoreFailures = false
    toolVersion = '7.5'
    configFile = new File('../../config/checkstyle/checkstyle.xml')
}

configurations.implementation.setCanBeResolved(true) 
jar {
    from configurations.implementation.collect { it.isDirectory() ? it : zipTree(it) }
	
	
(gradle-wrapper.properties)
distributionUrl=https\://services.gradle.org/distributions/gradle-7.5.1-bin.zip
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStorePath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME


https://github.com/gitpitch/gitpitch
