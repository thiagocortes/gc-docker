# Starting with a base image containing Java runtime
FROM openjdk:8u212-jdk-slim

# Add Maintainr Info
LABEL maintainer="thiagoscortes@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The Aplication's jar file 
ARG JAR_FILE=target/codestate-0.0.1-SNAPSHOT.jar

#Add the application's jar to the container
ADD ${JAR_FILE} codestate.jar

# Run the jar file
ENTRYPOINT ["Java", "-Djava.security.egd=file:/dev/./urandom","-jar", "/codestate.jar"]
