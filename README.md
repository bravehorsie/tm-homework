# A job interview homework

Traverses a list of log entries and calculates an order, based on each entry timestamp and group.

To run:

1. build with maven:
```shell
mvn clean install
```


2. execute jar with either of:
   1. with a default input bundled inside jar
   ```shell
   java -DinputAbsolutePath=/Users/rogrigor/Downloads/tm-input.txt -jar target/tm-homework-1.0-SNAPSHOT.jar
   ```
   2. with an input provided as program arg
   ```shell
   java -jar target/tm-homework-1.0-SNAPSHOT.jar ~/path-to/input.txt
   ```
   3. with an input provided as system property
   ```shell
   java -DinputAbsolutePath=/path-to/input.txt -jar target/tm-homework-1.0-SNAPSHOT.jar
   ```