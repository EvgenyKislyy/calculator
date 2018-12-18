# calculator

  There are 3 classes

Operation - that contains logic for math operations

Number service - that remembers both 2 latest numbers for the future, and history of all the numbers

Calculator - main class for reading user input, doing operations, and showing console output, 

I choosed Double because there are some fractions in the task description, and because it has pretty big range of available numbers

Operations in enum are easy extendable

List of integers in NumberService allow us to see the history, but slowly eats memory

With more time on project maybe I could write more tests

Running scripts (maven)

build java -jar target/calculator-1.0-SNAPSHOT.jar 


run cd java -jar target/calculator-1.0-SNAPSHOT.jar 
