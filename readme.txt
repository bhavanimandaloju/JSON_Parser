CONTENTS OF THIS FILE
---------------------
 * Introduction
 * Requirements
 * Recommended modules
 * Installation
 * Configuration
 * Troubleshooting
 * FAQ
 * Maintainers
 
 INTRODUCTION
------------
* This small java application consumes a webpage, 
processes the product urls and details and generates 
a JSON array with all the products on the webpage.

REQUIREMENTS
------------
* The program can be executed in all modern computers 
that have java installed and an Internet connection.

* The program was created as an Eclipse Java Project
and needs the Eclipse IDE (or a compatible IDE) in
order to amend, test or execute the source code.

* If you just need to build the application's jar
file without the use of Eclipse you need install
ANT in you system and execute the provided 'build.xml'
file from the baseline directory.

INSTALLATION
------------
* This is a standalone application so no installation 
is necessary.

* Locate the 'jsonparser.jar' java executable under 
the 'dist' directory and execute:
<java installation path>/bin/java -jar jsonparser.jar

CONFIGURATION
-------------
* The main configuration is 'hardcoded' in the 
'uk.co.sainsburys.configuration.ParserConfigConstants.java'
file and is self-explanatory.
 
* A second mechanism which allows to override the default configuration
with the use of a user customised properties file was planned
but due to lack of time will not be able to be part of this release.

MAINTAINERS
-----------
Current maintainers:
 * Michail Vasilakopoulos