Solution strategy:
* Refactor if-else chains with polymorphism, using inheritance

Domain/implementation ideas and devised requirements:
* GildedRose shall be stateful as it owns the items that are for sale
* The Item class (that we are not allowed to change) represents items that are "boxed"
* These items are "unboxed" in our ItemReceipt where we check if the item belongs to our sortiment

Advantages of this implementation:
* easy to implement
* refactoring did not break the implementation at any point
* wins already a lot of ground

Some disadvantages:
* inheritance with tight coupling - not nice
* logic scattered across inheritance hierarchy / item types --> unbalanced, asymmetric
* code structure eventually only scales limited when adding new item types
* item names are not yet constants/enums
* method GildedRose.getUnboxedItems() in production code exists only for testing purposes
* naming of test methods is not perfect/consistent
