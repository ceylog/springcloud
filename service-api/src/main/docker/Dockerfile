FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
