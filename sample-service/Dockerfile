FROM centos:7
ENV RELEASE_PATH target/sample-petstore-swarm.jar
RUN yum install -y \
    java-1.8.0-openjdk-headless \
  && yum clean all

WORKDIR /opt/sample-petstore

ADD ${RELEASE_PATH} /opt/sample-petstore

RUN groupadd -r duser -g 1001 \
    && useradd -u 1001 -r -g duser -d /opt/sample-petstore/ -s /sbin/nologin -c "Docker image user" duser \
    && chown -R duser:duser /opt/sample-petstore/ \
    && chgrp -R 0 /opt/sample-petstore && chmod -R g=u /opt/sample-petstore

USER 1001


EXPOSE 8080

ENV PORT_OFFSET=0
ENV LOGGING_LEVEL=INFO

CMD java -jar /opt/sample-petstore/sample-petstore-swarm.jar \
    -Dswarm.port.offset=${PORT_OFFSET} \
    -Dswarm.logging=${LOGGING_LEVEL}
