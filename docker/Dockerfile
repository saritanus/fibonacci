# Alpine based container with Java and Tomcat
FROM centos:centos8.2.2004
MAINTAINER Sarita Sethy

# Prepare environment
RUN mkdir -p /opt/oracle/fibonacci
ENV FIBONACCI_INSTALL_DIR /opt/oracle/fibonacci
ENV SPRING_CONFIG_LOCATION file:///$FIBONACCI_INSTALL_DIR/config
ENV JAVA_HOME $FIBONACCI_INSTALL_DIR/java
ENV CATALINA_HOME $FIBONACCI_INSTALL_DIR/tomcat
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin:$CATALINA_HOME/scripts
ENV LC_ALL en_US.UTF-8

# Copy requisite dependencies (JRE/Tomcat)
# These dependencies should have been already set up outside before
# docker build command is initiated.
COPY xlib/jdk-11.0.2+7-jre/ ${JAVA_HOME}/
COPY xlib/tomcat_8.5.35 ${CATALINA_HOME}/

RUN chmod +x ${CATALINA_HOME}/bin/*.sh

# Create tomcat user
RUN groupadd -r tomcat && \
  useradd -g tomcat -d ${CATALINA_HOME} -s /sbin/nologin  -c "Tomcat user" tomcat && \
  chown -R tomcat:tomcat ${CATALINA_HOME} ${JAVA_HOME} && \
  chmod u+w ${JAVA_HOME}/lib/security/cacerts
RUN  chmod -R 755 /var/opt/oracle/

COPY docker/fibonacci/tomcat/conf/ $CATALINA_HOME/conf/
COPY docker/fibonacci/tomcat/bin/ $CATALINA_HOME/bin/
COPY build/libs/fibonacci.war  ${CATALINA_HOME}/webapps
EXPOSE 8000
COPY docker/fibonacci/entrypoint.sh /
RUN chmod 755 /entrypoint.sh

USER tomcat
ENTRYPOINT ["/entrypoint.sh"]
CMD ["run"]


