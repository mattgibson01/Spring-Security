Spring Security Project

Requirements:
Java 21 SDK
Maven

Steps to start project
1. Clone Git Repo into Eclipse
2. Verify that the Java 21 SDK is the java version in the build path (Make sure this SDK is installed on the machine)
     a. Right-Click spring-sec-project>Build Path>Configure Build Path
     b. Libraries> Add Library > Modulepath > Add Library > JRE System Library > Installed JREs > Check jdk-21 > Apply and Close
3. Modify server.properties property "project.base" to be the path to the folder spring-sec-project
4. Right click the spring-sec-project folder > Maven > Update Project
5. Navigate to class App.java in package: com.interview.spring_sec_project > Right click class > Run as > Java Application
