# calculator

  There are 4 classes

Calculator - main class for doing operations

NumberService -  remembers both 2 latest numbers for the future, and history of all the numbers

Operation - that contains logic for math operations, easy extendable

InputReader is the intarface for input and output data in my app, easy to implement and change the way of input/output

I choosed Double for the numbers format because there are some fractions in the task description, and because it has pretty big range of available numbers


List of integers in NumberService allow us to see the history, but of course it takes some space in memory

With more time on project maybe I could write more tests
And check the max_min ranges
And try to check - maybe BigDecimal is more appropriate for that

Running scripts (maven)

build 

 mvn package



run 

java -jar target/calculator-1.0-SNAPSHOT.jar 
