# 📍 surveyoroftinytown-java

`surveyoroftinytown-java` provides Java utilities for working with data from [`surveyoroftinytown`](https://github.com/thunken/surveyoroftinytown) and the API on https://tracker.archiveteam.org:1338/status.


## Latest release

[![Release](https://jitpack.io/v/thunken/surveyoroftinytown-java.svg?style=flat-square)](https://github.com/thunken/surveyoroftinytown-java/releases)

To add a dependency on this project using Gradle, Maven, sbt, or Leiningen, we recommend using [JitPack](https://jitpack.io/#thunken/surveyoroftinytown-java/1.0.3). The Maven group ID is `com.github.thunken`, and the artifact ID is `surveyoroftinytown-java`.

For example, for Maven, first add the JitPack repository to your build file:
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

And then add the dependency:
```xml
	<dependency>
	    <groupId>com.github.thunken</groupId>
	    <artifactId>surveyoroftinytown-java</artifactId>
	    <version>1.0.3</version>
	</dependency>
```

## Documentation

* Javadoc: https://thunken.github.io/surveyoroftinytown-java/
  * Note: the current Javadoc for this project is incomplete. We rely on [Lombok](https://projectlombok.org/) to generate boilerplate code, and Lombok does not plug into Javadoc. Generated methods and constructors are not included, and the Javadoc for other methods and constructors may be incomplete. See [delombok](https://projectlombok.org/features/delombok) for more information.
