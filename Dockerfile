# Pull an Alpine image with jre
FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

#Create WorkSpace. Here the path is /usr/share/dockerraj and this will be in the alpine container not in Windows
WORKDIR /usr/share/dockerraj

#Add Jar files from the target folder

ADD target/selenium-docker.jar         selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs                       libs

#Add Suite files

ADD searchPageTestNG.xml              searchPageTestNG.xml

#ADD healthcheck script

RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

# ENTRY POINT containing BROWSER, HUB_HOST and MODULE

ENTRYPOINT sh healthcheck.sh
