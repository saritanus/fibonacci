# Alpine based container with Java and Tomcat
FROM centos:centos8.2.2004
MAINTAINER Sarita Sethy

# Prepare environment
RUN mkdir -p /opt/oracle/fibonacci
ENV FIBONACCI_INSTALL_DIR /opt/oracle/fibonacci
ENV JAVA_HOME $FIBONACCI_INSTALL_DIR/java
ENV CATALINA_HOME $FIBONACCI_INSTALL_DIR/tomcat
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin:$CATALINA_HOME/scripts

# Copy requisite dependencies (JRE/Tomcat)
# These dependencies should have been already set up outside before
# docker build command is initiated.
COPY xlib/java/jdk-11.0.2+7-jre/ ${JAVA_HOME}/
COPY xlib/tomcat/tomcat_8.5.35 ${CATALINA_HOME}/

RUN chmod +x ${CATALINA_HOME}/bin/*.sh

# Create tomcat user
RUN groupadd -r tomcat && \
  useradd -g tomcat -d ${CATALINA_HOME} -s /sbin/nologin  -c "Tomcat user" tomcat && \
  chown -R tomcat:tomcat ${CATALINA_HOME} ${JAVA_HOME} && \
  chmod u+w ${JAVA_HOME}/lib/security/cacerts

COPY build/libs/fibonacci.war  ${CATALINA_HOME}/webapps
EXPOSE 8000
COPY docker/entrypoint.sh /
RUN chmod 755 /entrypoint.sh

USER tomcat
ENTRYPOINT ["/entrypoint.sh"]
CMD ["run"]


