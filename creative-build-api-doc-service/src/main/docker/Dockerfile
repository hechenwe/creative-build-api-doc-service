FROM java
VOLUME /tmp
ADD creative-build-api-doc-service.jar cbads.jar
RUN bash -c 'touch /cbads.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /cbads.jar" ]