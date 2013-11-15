grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
        excludes 'xercesImpl', 'xml-apis'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        compile (group:'org.apache.poi', name:'poi', version:'3.9');
        compile (group:'org.apache.poi', name:'poi-ooxml', version:'3.9') {
            excludes 'stax-api'
        }
        compile ('org.apache.poi:poi-ooxml-schemas:3.9') {
            excludes 'stax-api'
        }
        compile ('dom4j:dom4j:1.6.1')
        runtime('xerces:xercesImpl:2.11.0') {
            excludes 'xml-apis'
        }
    }
    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}
