# First coding round for Impact.


From within the **Impact** folder:
### To compile the main files with tester.java:
        javac -d bin src/test/tester.java src/numberrangesummarizer/*.java

### To use tester.java:
        java -cp bin tester data/numbers.txt

### To compile test cases:
        javac -d bin -cp lib/junit-platform-console-standalone-1.8.2.jar src/test/*.java src/numberrangesummarizer/*.java

### To run test cases:
        java -jar lib/junit-platform-console-standalone-1.8.2.jar --class-path bin --scan-class-path
