#!/bin/sh
CLASS_NAME="rest.hello.HelloWorldService"
SERVICE_NAME="HelloWorldService"
rm -rf bin/*
cd src
scrpath=$(echo $CLASS_NAME | sed 's/\./\//g')
javac ${scrpath}.java -d ../bin/ 
cd ../
rm -rf WEB-INF/classes
mkdir WEB-INF/classes
cp -r bin/* WEB-INF/classes/
jar cvf $SERVICE_NAME.war WEB-INF/*
asadmin deploy --force $SERVICE_NAME.war