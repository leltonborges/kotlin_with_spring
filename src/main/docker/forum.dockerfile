FROM gradle:jdk17 as build
WORKDIR /app

COPY . ./
RUN ["gradle"]
CMD ["build"]

FROM openjdk:17-buster as hom
WORKDIR /app
COPY --from=build /app/build/libs/*SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java"]
CMD ["-jar","application.jar"]