Advantages of this solution:
* easy to implement
* replaces if-else chains by polymorphism
* refactoring did not break the implementation at any point
* wins already a lot of ground

Some disadvantages:
* inheritance with tight coupling - not nice
* logic scattered across inheritance hierarchy / item types --> unbalanced
* code structure eventually only scales limited when adding new item types
* one single test case (GildedRoseTest) instead of test cases per item type
* method GildedRose.getItems() in production code exists only for testing purposes
* naming of test methods is not perfect/consistent
