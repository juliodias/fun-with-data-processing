FROM apache/nifi:1.8.0

COPY flow.xml.gz /opt/nifi/nifi-1.8.0/conf/
COPY lib/mysql-connector-java-8.0.15.jar /opt/nifi/nifi-1.8.0/lib/

EXPOSE 8080
ENTRYPOINT /opt/nifi/nifi-1.8.0/bin/nifi.sh run
