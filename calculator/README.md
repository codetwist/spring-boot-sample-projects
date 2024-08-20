### Calculator
_Erwin Cabral_

* The _Operation_ Enum holds the BiFunction mapped to each operation.
* When new operations are added, only the _Operation_ Enum is updated. You just need to add a new Enum and mapped the new function.
* Calculator.calculate() is chained by returning a new instance initialized by the previously computed result. In this case, Calculator is immutable. 
It creates a new Calculator initialized with the previous computed result.


 