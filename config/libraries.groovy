// A single place to keep all information about dependency versions.
// This allows you to keep versions consistent across sub-projects.

def SLF4J_VERSION = '1.6.4'

libraries = [

	// Logging

	slf4j_api: 'org.slf4j:slf4j-api:' + SLF4J_VERSION,
	jcl_slf4j: 'org.slf4j:jcl-over-slf4j:' + SLF4J_VERSION,
	log4j_slf4j: 'org.slf4j:log4j-over-slf4j:' + SLF4J_VERSION,
	
	logback: 'ch.qos.logback:logback-classic:1.0.0',

	// Testing

	junit: 'junit:junit:4.10',
	mockito: 'org.mockito:mockito-core:1.9.0-rc1',
	
	// Commons
	
	guava: 'com.google.guava:guava:10.0.1',
    commons_lang: 'commons-lang:commons-lang:2.6',
]
