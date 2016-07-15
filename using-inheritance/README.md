Advantages of this solution:
* easy to implement
* replaces if-else chains by polymorphism
* refactoring did not break the implementation at any point
* wins already a lot of ground

Some disadvantages:
* inheritance with tight coupling - not nice
* logic scattered across inheritance hierarchy / item types --> unbalanced, asymmetric
* code structure eventually only scales limited when adding new item types
* method GildedRose.getUnboxedItems() in production code exists only for testing purposes
* naming of test methods is not perfect/consistent
