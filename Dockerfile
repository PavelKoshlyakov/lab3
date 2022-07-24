#FROM openjdk:8
#EXPOSE 5432
FROM ubuntu:latest
ADD target/kotiki.jar kotiki.jar