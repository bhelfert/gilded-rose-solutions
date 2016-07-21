Solution strategy:
* Refactor if-else chains by using polymorphism with inheritance

Domain/implementation ideas and devised requirements/restrictions:
* GildedRose shall be stateful as it owns the items that are for sale
* The Item class (that we are not allowed to change) represents items that are "boxed"
* These items are "unboxed" in our ItemsReceipt where we check if the item belongs to our sortiment
* For writing tests only JUnit (with AssertJ) is allowed to be used - not a nice BDD framework 

Advantages of this implementation:
* New items are automatically added to the AutomaticSortiment when they are an UnboxedItem and have a NAME constant
* The application works when unknown items are unboxed  
* Tests focus exclusively on the functionality of the object under test due to mocked dependencies and a test pyramid 
* ItemsReceipt and Sortiment are now decoupled

Some disadvantages:
* Addtional complexity (Strategy pattern, usage of Reflection, additional libraries, mock tests) does not pay-off for
such a small project -> approx. +63% LOC!
* Inheritance with tight coupling - not nice
* Logic scattered across inheritance hierarchy / item types --> unbalanced, asymmetric
* Getter methods in production code exist only for testing purposes