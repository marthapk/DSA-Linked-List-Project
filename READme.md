# **Linked List Management System**





##### **Objective**



A menu-driven console application for practicing linked list data structures. It contains a Singly Linked List and a Doubly Linked List, both built from scratch with a custom node class. No array or built-in list collection is used.



##### **Language Used: Java**



###### Features

* Main menu to choose the Singly list, the Doubly list, a comparison, or exit
* 19 operations on the Singly list and 20 on the Doubly list, each written as a separate method
* Input checks for invalid menu choices, invalid positions, empty lists and values that are not found
* Doubly list keeps both head and tail references
* Comparison of the two list types from the main menu



##### **Singly Linked List**



Each node stores data and a next reference. The list keeps only a head reference, so the only direction of travel is forward.



##### **Doubly Linked List**



Each node stores data, a prev reference and a next reference. The list keeps both head and tail, so it can be traversed in both directions, and inserting or deleting at the end is O(1).



##### **Operations**



|#|	**Singly Linked List**|	**Doubly Linked List**|
|-|-|-|
|1|	Insert at Beginning|	Insert at Beginning|
|2|	Insert at End|        Insert at End|
|3|	Insert at Position|	Insert at Position|
|4|	Insert After a Node|	Insert After a Node|
|5|	Insert Before a Node|	Insert Before a Node|
|6|	Delete from Beginning|	Delete from Beginning|
|7|	Delete from End|	Delete from End|
|8|	Delete from Position|	Delete from Position|
|9|	Delete by Value|	Delete by Value|
|10|	Search|	Search|
|11|	Update|	Update|
|12|	Display|	Display Forward|
|13|	Count Nodes|	Display Backward|
|14|	Find Maximum|	Count Nodes|
|15|	Find Minimum|	Find Maximum|
|16|	Find Middle Element|	Find Minimum|
|17|        Reverse|	Find Middle Element|
|18|	Sort|        Reverse|
|19|	Remove Duplicates|	Sort|
|20|	Exit|	Remove Duplicates|
|21|        ---|	Exit|



##### **Design notes**

* Positions are 1-based. Insert accepts positions 1 to size+1. Delete accepts 1 to size.
* Insert After / Before / Delete by Value / Update act on the first node that matches the value.
* Middle element uses slow and fast references. For an even-length list, the second of the two middle nodes is returned (for 10 -> 20 -> 30 -> 40 the middle is 30).
* Sort is Bubble Sort that swaps node data.
* Remove Duplicates keeps the first occurrence of each value and removes the later ones.
* Reverse in the Singly list uses prev, current and next references. In the Doubly list it swaps prev and next in every node and then swaps head and tail.



##### **How to Run**



Requirements: JDK 8 or later.



1. Keep Main.java, SinglyLinkedList.java and DoublyLinkedList.java in the same folder (src/).

2\. Compile:

&#x20;  javac Main.java SinglyLinkedList.java DoublyLinkedList.java

3\. Run:

&#x20;  java Main





##### **Sample Output**



Singly linked list:

40 -> 10 -> 30 -> 20 -> 50 -> NULL

(after Sort)    10 -> 20 -> 30 -> 40 -> 50 -> NULL

(after Reverse) 50 -> 40 -> 30 -> 20 -> 10 -> NULL



Doubly linked list:

Forward:   NULL <- 10 <-> 20 <-> 30 <-> 40 -> NULL

Backward:  NULL <- 40 <-> 30 <-> 20 <-> 10 -> NULL



##### **Time Complexity**



|**Operation**|        **Singly**|        **Doubly**|
|-|-|-|
|Insert at Beginning|	O(1)|	O(1)|
|Insert at End|	O(n) (no tail)|	O(1) (with tail)|
|Insert at Position|	O(n)|	O(n)|
|Insert After / Before a Node|	O(n)|	O(n)|
|Delete from Beginning|	O(1)|	O(1)|
|Delete from End|	O(n)|	O(n)|
|Delete from Position / by Value|	O(n)|	O(n)|
|Search / Display / Count|	O(n)|	O(n)|
|Find Max / Min / Middle|	O(n)|	O(n)|
|Reverse|	O(n), extra space O(1)|        O(n), extra space O(1)|
|Bubble Sort|	O(n^2)|	O(n^2)|
|Remove Duplicates|	O(n^2)|	O(n^2)|





