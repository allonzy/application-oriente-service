#!/bin/sh
SRC_PATH="carnetcontact/"
SERVICE_NAME="carnetContactService"
rm -rf bin/*
cd src
javac ${SRC_PATH}/*.java -d ../bin/ 
cd ../
rm -rf WEB-INF/classes
mkdir WEB-INF/classes
cp -r bin/* WEB-INF/classes/
jar cvf $SERVICE_NAME.war WEB-INF/*
asadmin deploy --force $SERVICE_NAME.war