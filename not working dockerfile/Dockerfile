FROM bellsoft/liberica-openjdk-alpine:17.0.8

#Install curl and JQ
RUN apk add curl jq

# Workspace
WORKDIR /home/selenium-docker

# Add the required files from target/docker-resources to /home/selenium-docker
ADD ../target/docker-resources       ./
ADD ../runner.sh                     ./

#Run the test
#ENTRYPOINT java -cp 'libs/*' \
#           -Dselenium.grid.enabled=true \
#           -Dselenium.grid.hubhost=${HUB_HOST} \
#           -Dbrowser=${BROWSER} \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           test-suites/${TEST_SUITE}

#Entrty point
ENTRYPOINT sh runner.sh