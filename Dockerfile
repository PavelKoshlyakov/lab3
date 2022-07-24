#FROM openjdk:8
#EXPOSE 5432
FROM ubuntu:latest
ADD Controllers/target/kotiki.jar kotiki.jar