# select image
FROM maven:3.6.3-jdk-8

# copy your source tree
COPY ./ ./

# build for release
RUN mvn package

# set the startup command to run your binary
CMD ["java", "-jar", "target/cloud-sdk-sample.jar"]