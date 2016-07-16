Solution strategy:
* Refactor if-else chains by using polymorphism with inheritance

Domain/implementation ideas and devised requirements/restrictions:
* GildedRose shall be stateful as it owns the items that are for sale
* The Item class (that we are not allowed to change) represents items that are "boxed"
* These items are "unboxed" in our ItemsReceipt where we check if the item belongs to our sortiment
* For writing tests only JUnit (with AssertJ) is allowed to be used - not a nice BDD framework 

Advantages of this implementation:
* Easy to implement
* Refactoring did not break the implementation at any point
* Wins already a lot of ground

Some disadvantages:
* Inheritance with tight coupling - not nice
* Logic scattered across inheritance hierarchy / item types --> unbalanced, asymmetric
* Getter methods in production code exist only for testing purposes