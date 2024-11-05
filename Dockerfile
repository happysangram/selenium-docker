FROM bellsoft/liberica-openjdk-alpine:21

# Install curl jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# Add the required files
ADD target/docker-resources     ./
ADD runner.sh                   runner.sh

# Make the runner script executable
RUN chmod +x runner.sh

# Set the entry point to the runner script
ENTRYPOINT ["sh", "runner.sh"]

##Run the test
#ENTRYPOINT java -cp 'libs/*' \
#           -Dselenium.grid.enabled=true \
#           -Dselenium.grid.hubhost=${HUB_HOST} \
#           -Dbrowser=${BROWSER} \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           test-suites/${TEST_SUITE}