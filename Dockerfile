From openjdk:8
copy ./target/spring-boot-kafka-0.0.1-SNAPSHOT.jar spring-boot-kafka.jar
CMD ["java","-jar","spring-boot-kafka.jar"]