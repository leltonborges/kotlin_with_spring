FROM gradle:jdk17 as build
WORKDIR /app
COPY . ./
RUN ["gradle", "clean", "build"]

FROM openjdk:17.0.2-jdk as hom
ENV PORT=8090
WORKDIR /app
COPY --from=build /app/build/libs/*SNAPSHOT.jar ./app/application.jar
EXPOSE $PORT

ENTRYPOINT ["java"]
CMD ["-jar","application.jar"]