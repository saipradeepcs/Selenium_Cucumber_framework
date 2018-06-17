# Selenium_Cucumber_framework
A Behavior Driven Development framework

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need to have following software(s)/tools installed in your machine

* [Eclipse IDE](http://www.eclipse.org/downloads/eclipse-packages/) - IDE used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java
* [Cucumber eclipse plug-in] (http://cucumber.github.com/cucumber-eclipse/update-site) - BDD language used
* [junit] (This comes by default when you create a new Maven Project)
* [Selenium 3.11.0] (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.12.0)
* [Cucumber JVM: JUnit » 1.2.5] (https://mvnrepository.com/artifact/info.cukes/cucumber-junit/1.2.5)
* [Cucumber JVM: Java » 1.2.5] (https://mvnrepository.com/artifact/info.cukes/cucumber-java/1.2.5)
* [Cucumber JVM: PicoContainer » 1.2.4] (https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer/1.2.4) - Pico Container to share test context
* [Cucumber Extents Report] (https://mvnrepository.com/artifact/com.vimalselvam/cucumber-extentsreport/3.0.2)
## Running the tests

Once you pull the project. Navigate to folder src/test/java->TestRunner_Smokes->Run as Junit Test

### Break down into end to end tests

The above test when run as junit, initiallly it will read the annotation @RunWith(Cucumber.class), then will read the options that re provied in @CucumberOptions annotation.
Options defined @CucumberOptions annotation are very important as these options will define 
* what features to choose
* location of the stepdefintion(s)
* what tags to include
* report generation plug-ins if any 

```
Give an example
```
