FROM gradle:jdk21 as builder

WORKDIR /app

COPY src/main src/main/

COPY build.gradle .

COPY settings.gradle .

RUN ["gradle", "--no-daemon", "build"]

FROM openjdk:21

WORKDIR /app

#ENV       POSTGRES_DB=alexandrina
#          POSTGRES_USE=postgres
#          POSTGRES_PASSWORD=postgres

COPY --from=builder /app/build/libs/ipp-5-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/ipp-5-0.0.1-SNAPSHOT.jar"]