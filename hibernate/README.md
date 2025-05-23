# HIBERNATE


## Generate A QuickStart

```
$ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=com.palhar -DartifactId=hibernate-master -DinteractiveMode=false


Set the Java compiler version to 1.8 In <properties>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
OR
You can set the surefire plugin
The plugin configuration is more for fine-grained control or when you need to override the default behavior.
    <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.1</version>
    </plugin>


Add Build (<build>) & Plugin
    <build>
        <pluginManagement>
            <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
                <configuration>
                <source>1.8</source>
                <target>1.8</target>
                </configuration>
            </plugin>

            </plugins>
        </pluginManagement>
    </build>

$ mvn clean install


---------------------------------------------------------------
Convert This To WAR
---------------------------------------------------------------
Now change packaging to war
    <packaging>war</packaging>

Add maven-war-plugin
    <plugin>
        <artifactId>maven-clean-plugin</artifactId>
        <version>3.1.0</version>
    </plugin>
    <plugin>
        <artifactId>maven-resources-plugin</artifactId>
        <version>3.0.2</version>
    </plugin>
    <plugin>
        <artifactId>maven-install-plugin</artifactId>
        <version>2.5.2</version>
    </plugin>
    <plugin>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>2.8.2</version>
    </plugin>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.2</version> <configuration>
        </configuration>
    </plugin>


A WAR file expects specific directories for web resources.
An src/main/webapp directory, optionally, WEB-INF inside it

$ mkdir -p src/main/webapp/WEB-INF


Add  web.xml


[[[[[
    mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeGroupId=org.apache.maven.archetypes
    -DgroupId=com.palhar -DartifactId=my-webapp -DarchetypeVersion=1 -DinteractiveMode=false
]]]]]


javax.servlet-api dependency: For any web application, you'll need the Servlet API. scope=provided means the application server (like Tomcat, JBoss, Jetty) will provide this at runtime, so it won't be bundled in your WAR.

<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope> <!-- Tomcat will provide it -->
</dependency>



Now add Tomcat 7
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
        <port>8080</port>
        <path>/</path>
        <reloadable>true</reloadable>
        </configuration>
    </plugin>


Enable Hot Redeployment
    In tomcat plugin
    <reloadable>true</reloadable>

For reload to work your IDE should automatically compile your .java files into .class files when you save them


NOW RUN !!
$ mvn org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:run

```


## Working With Hibernate

```
Add hibernate & related dependencies in pom.xml

    hibernate-core
    javax.persistence-api (Now Jakarta)
    mysql-connector-java


Create DB & Add Details To hibernate.cfg.xml
    CREATE DATABASE subrat;
    CREATE DATABASE hibernate_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

    hbm2ddl.auto will create tables within an existing database

    src/main/resources/hibernate.cfg.xml
        Tells Hibernate how to connect to the database
        Which dialect to use
        Which entity classes it should manage




Create an entity
    src/main/java/com/palhar/hibernatemaster/entity/User.java

Work With Hibernate
    Create a Hibernate Utility Class
    src/main/java/com/palhar/hibernatemaster/util/HibernateUtil.java

Create a Simple Servlet to Interact with Hibernate
    src/main/java/com/palhar/hibernatemaster/servlet/UserServlet.java

    HERE WE DID WITH HQL - HIBERNATE QUERY LANGUAGE

Now Run !!
```
---
---



