#!/bin/bash

echo "Pulling packmule server code"
cd $(git rev-parse --show-toplevel)
unset LC_CTYPE
git pull origin master
if [ $? != "0" ]; then
   echo "Failed on git pull"
   exit 1
fi

echo "Building swagger server"
BUILD_FLAG="-Dmaven.buildNumber.doCheck=true ${BUILD_FLAG}"
mvn clean package $BUILD_FLAG
if [ $? != "0" ]; then
   echo "Failed to build swagger server"
   exit 1
fi

echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo "@@   server must have successfully built to continue   @@"
echo "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
echo "Hit Ctrl-c to abort, Enter continue"
read

echo "Shutting down swagger server"
/etc/init.d/swagger stop
sleep 2

TARGET_DIR=/opt/swagger
echo "Purging ancient swagger server binaries"
find ${TARGET_DIR} -maxdepth 1 -mtime +15 -type f -name '*.jar' -print0 | xargs -0 rm

echo "Deploying new swagger server binary"
# BUILD_NUMBER=$(git rev-parse --short HEAD)
JAR_NAME=swagger_api-0.0.1-SNAPSHOT.jar
#TARGET_JAR_NAME=packmule-1.0-SNAPSHOT.jar
cp target/${JAR_NAME} ${TARGET_DIR}/
#rm ${TARGET_DIR}/${TARGET_JAR_NAME}
#ln -s ${TARGET_DIR}/${JAR_NAME} ${TARGET_DIR}/${TARGET_JAR_NAME}

echo "Starting packmule server"
/etc/init.d/swagger start
echo "Done"