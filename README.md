# SLF4J-Color

![Release](https://img.shields.io/badge/release-v0.1.0--SNAPSHOT-red)
![License](https://img.shields.io/badge/license-MIT-blue)
![Maintenance](https://img.shields.io/maintenance/yes/2020.svg)

Simple Logging Implementation for SLF4J, similar to SLF4J-Simple, but with ANSI colors supported. 

As this is just made for rapid development, you don't need to configure anything. The default log level is DEBUG (which can be changed using ```SLF4JColor.setDefaultLogLevel```).

The shaded JAR also includes slf4j - meaning you don't need to import/shade it explicitly.

Therefore, this project is **NOT** for production but only used in development and then later replaced with e.g. a implementation that supports logging to files.

## Requirements

It's made for use with Java 11 or later.

Currently we don't offer a public build server, therefore you need to build it yourself using maven.

## Installation

Build it using maven:

```bash
mvn clean install
```
 
### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.xiamli</groupId>
  <artifactId>slf4j-color</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.xiamli:slf4j-color:0.1.0-SNAPSHOT"
```

## Usage

```java
import com.xiamli.slf4j_color.SLF4JColor;
import com.xiamli.slf4j_color.misc.LogLevel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example {

    public static void main(String[] args) {
        SLF4JColor.setDefaultLogLevel(LogLevel.INFO); // Set a default log level; defaults to INFO if not set
        SLF4JColor.setDateFormat("HH:mm:ss"); // Set a date format; defaults to yyyy-MM-dd HH:mm:ss.SSS if not set

        SLF4JColor.setLogLevel(LogLevel.WARN, "com.xiamli.slf4j_color.Example"); // Set specific level for a class
        SLF4JColor.setPackageLogLevel(LogLevel.TRACE, "com.xiamli"); // Enable trace logging for all classes within the com.xiamli package

        log.info("This is a message from the example!");
        
        log.error("Oops, a mistake happened!", new NumberFormatException());
    
        // As this is built upon the new SLF4J 2.0 Fluent API, you can also use that if you want
        log.atDebug().addKeyValue("ping", database.getPing()).log("Connected to database.");
    }
}
```
