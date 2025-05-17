# Open JDK
- https://github.com/openjdk/jdk/tree/master/src
- https://github.com/openjdk/jdk/graphs/contributors



## java.base: [THE_HEART] This is arguably the most fundamental module. It contains the core Java APIs that are essential for any Java application. You'll find source code here for things like:

- Basic data types (int, float, String, Object)
- Collections (List, Map, Set)
- Input/Output operations (InputStream, OutputStream)
- Networking (Socket, URL)
- Concurrency utilities (Thread, Runnable, Executor)
- Reflection
- Security features


## java.compiler: As the name suggests, this directory houses the source code for the javac compiler. This is the tool responsible for taking your .java source files and translating them into .class bytecode files that the Java Virtual Machine (JVM) can understand and execute. Peeking in here would reveal the intricate processes involved in lexical analysis, parsing, semantic analysis, and code generation.

## java.desktop: This module contains APIs related to desktop application development. You'll find code for:

## Swing: The older GUI toolkit for Java.
## AWT (Abstract Window Toolkit): The platform-dependent native GUI toolkit that Swing is built upon.
- Drag and drop functionality.
- Clipboard operations.
- Image processing.
- Printing.

## java.instrument: This module provides support for the Java Instrumentation API. This powerful API allows you to inspect and modify the bytecode of running Java applications. It's often used for:
- Profiling tools to monitor performance.
- Debugging agents to step through code.
- Hot-swapping code changes in development environments.
- Creating custom monitoring and management solutions.

## java.management: This directory contains the Java Management Extensions (JMX) API. JMX provides a standard way to monitor and manage Java applications. It allows you to expose management beans (MBeans) that provide information about the application's state and allow for runtime configuration changes.

## java.net.http: This relatively newer module provides a modern HTTP client API that supports HTTP/2 and WebSockets. It offers a more flexible and asynchronous way to handle HTTP requests compared to the older java.net package.

## java.rmi: This module deals with Remote Method Invocation (RMI), a mechanism that allows Java objects running in different JVMs to communicate with each other.

## java.scripting: This module provides support for scripting languages to be integrated with Java applications. It includes the Scripting API and engines for languages like JavaScript (Nashorn, though it has been removed in later JDK versions).

## java.security: This module contains classes related to security features in Java, including cryptography, authentication, and authorization.

## java.sql: This module provides the JDBC (Java Database Connectivity) API, which allows Java applications to interact with various relational databases.

## java.xml: This module includes APIs for processing XML (Extensible Markup Language) data, including parsing, transforming, and validating XML documents.



### jdk.accessibility: APIs for accessibility features.
### jdk.attach: Mechanisms for attaching to running JVM processes.
### jdk.crypto.ec, jdk.crypto.mscapi: Providers for cryptographic algorithms.
### jdk.hotspot.agent: Agents specific to the HotSpot JVM.
### jdk.internal.*: Internal implementation details of the JDK (generally not intended for direct use by application developers).
### jdk.jfr: Java Flight Recorder, a profiling and diagnostic tool.
### jdk.jlink: Tools for creating custom runtime images.
### jdk.jshell: The JShell interactive Java REPL (Read-Eval-Print Loop).
### jdk.management.jfr: Management support for Java Flight Recorder.
### jdk.net: Networking extensions.
### jdk.nio.mapmode: Memory-mapped file extensions.
### jdk.sctp: Support for the SCTP (Stream Control Transmission Protocol).
### jdk.security.auth, jdk.security.jgss, jdk.security.sasl: Security-related APIs.
### jdk.unsupported: Unofficial and unsupported APIs (use with caution!).
### jdk.vm.ci: The Graal compiler interface.





