Chapter 3: Methods Common to All Objects
===

####Item 8: Obey the general contract when overriding equals

Contract for `equals` method:

* **Reflexive:** For any non-null reference value `x` , `x.equals(x)` must return true.
* **Symmetric:** For any non-null reference values `x` and `y`, `x.equals(y)` must return true if and only if `y.equals(x)` returns true.
* **Transitive:** For any non-null reference values `x , y , z`, if `x.equals(y)` returns true and `y.equals(z)` returns true, then `x.equals(z)` must return true.
* **Consistent:** For any non-null reference values `x` and `y`, multiple invocations of `x.equals(y)` consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
* For any non-null reference value `x`, `x.equals(null)` must return false.

> Once you’ve violated the equals contract, you simply don’t know how other objects will behave when confronted with your object.

####Fundamental problem of equivalence relations in object-oriented languages.

There is no way to extend an instantiable class and add a value component while preserving the equals contract.

####Item 9: Always override hashCode when you override equals

Contract for `hashCode()` method:

* Consistent: whenever it is invoked on the same object more than once during an execution of an application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the
object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.

* If for two objects `A, B`: `A.equals(B) = true`, 
    then `A.hashCode() = B.hashCode()`.

* It is not required to produce distinct `hashCode()` results if objects are unequal according to `equals()` method. However, it can improve performance of hash tables.
* 

####Item 10: Always override toString

> Why? Well, providing a good toString implementation makes your class much more pleasant to use. When practical, the `toString` method should return all of the interesting information contained in the object.

It can be useful to specify the format of the return value in documentation.

####Item 11: Override clone judiciously

####Item 12: Consider implementing Comparable 
