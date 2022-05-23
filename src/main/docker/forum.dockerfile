FROM maven:3-openjdk-17 as build
RUN ["mvn"]
CMD ["clean", "package"]

FROM openjdk:17-buster as hom
WORKDIR /app
COPY --from=build /app/target/*.jar ./application.jar

ENTRYPOINT ["java"]
CMD ["-jar","application.jar"]