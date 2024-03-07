FROM openjdk:17-jdk-alpine
EXPOSE 8080
RUN mkdir config logs
ENV TZ="Asia/Kuala_Lumpur"
COPY target/autoparts-ms-maintenance.jar autoparts-ms-maintenance.jar
COPY config/* config/
ENTRYPOINT ["sh", "-c", "java -jar -Xlog:gc*:file=/logs/gc.log autoparts-ms-maintenance.jar"]
