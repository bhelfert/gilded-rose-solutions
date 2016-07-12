Advantages of this solution:
* easy to implement
* replaces if-else chains by polymorphism
* refactoring did not break the implementation at any point
* wins already a lot of ground

Some disadvantages:
* inheritance with tight coupling - not nice
* code structure eventually only scales limited when adding new item types
* ugly naming, e.g. AbstractItem
* method GildedRose.getItems() exists only for testing purposes
* naming of test methods is not perfect/consistent
