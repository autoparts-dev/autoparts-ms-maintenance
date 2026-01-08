FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
RUN mkdir config logs
ENV TZ="Asia/Kuala_Lumpur"
COPY target/autoparts-ms-maintenance.jar autoparts-ms-maintenance.jar
COPY config/* config/
COPY global/* global/
ENTRYPOINT ["sh", "-c", "java -jar -Xlog:gc*:file=/logs/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/logs/$(date +%s).hprof autoparts-ms-maintenance.jar"]
