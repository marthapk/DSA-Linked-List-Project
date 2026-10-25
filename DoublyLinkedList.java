import java.util.Scanner;

public class DoublyLinkedList {

    class node {
        int data;
        node prev; 
        node next;

        node (int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    node head;
    node tail;

    public void displayForward() {

        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("NULL <- ");
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }

    public void displayBackward() {

        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        System.out.print("NULL <- ");
        node temp = tail;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println(" -> NULL");
    }

    public void insertAtBeginning(int data) {

        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data + " inserted at beginning.");
    }

    public void insertAtEnd(int data) {

        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data+ " inserted at end.");
    }

    public void insertAtPosition(int data, int position) {

        int size = countNodes();
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }
        if (position == size + 1) {
            insertAtEnd(data);
            return;
        }
        node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        node newNode = new node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println(data + " inserted at position " + position);
    }

    public void insertAfterNode(int data, int target) {

        node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(target + " node not found.");
            return;
        }
        node newNode = new node(data);
        newNode.prev = temp;
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }
        temp.next = newNode;
        System.out.println(data + " inserted after " + target);
    }

    public void insertBeforeNode(int data, int target) {

        node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(target + " node not found.");
            return;
        }
        node newNode = new node(data);
        newNode.next = temp;
        newNode.prev = temp.prev;
        if (temp.prev != null) {
            temp.prev.next = newNode;
        } else {
            head = newNode;
        }
        temp.prev = newNode;
        System.out.println(data + " inserted before " + target);
    }

    public void deleteFromBeginning() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println(head.data + " deleted from beginning.");
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromEnd() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println(tail.data + " deleted from end.");
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteFromPosition(int position) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int size = countNodes();
        if (position < 1 || position > size) {
            System.out.println("Invalid position.");
            return;
        }
        node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data + " deleted from position " + position);
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
    }

    public void deleteByValue(int data) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(data + " not found in list.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
        System.out.println(data + " deleted from list.");
    }

    public void search(int data) {

        node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println(data + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println(data + " not found in list.");
    }

    public void update(int oldValue, int newValue) {
        
        node temp = head;
        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                System.out.println(oldValue + " updated to " + newValue);
                return;
            }
            temp = temp.next;
        }
        System.out.println(oldValue + " not found in list.");
    }

    public int countNodes() {
        
        int cnt = 0;
        node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public void findMax() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int max = head.data;
        node temp = head;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum element: " + max);
    }

    public void findMin() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int min = head.data;
        node temp = head;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum element: " + min);
    }

    public void findMiddle() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element is " + slow.data);
    }

    public void reverse() {

        node curr = head;
        node temp = null;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
        System.out.println("List reversed.");
    }

    public void sort() {

        if (head == null || head.next == null) {
            System.out.println("List is empty or has only one element.");
            return;
        }
        boolean swapped;
        node end = null;
        do {
            swapped = false;
            node temp = head;
            while (temp.next != end) {
                if (temp.data > temp.next.data) {
                    int t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                    swapped = true;
                }
                temp = temp.next;
            }
            end = temp;
        } while (swapped);
        System.out.println("List is sorted in ascending order.");
    }

    public void removeDuplicates() {

        if (head == null || head.next == null) {
            System.out.println("List is empty or has only one element.");
            return;
        }
        boolean removed = false;
        node temp = head;
        while (temp != null) {
            node runner = temp.next;
            while (runner != null) {
                node nextNode = runner.next;
                if (runner.data == temp.data) {
                    if (runner.prev != null) {
                        runner.prev.next = runner.next;
                    } else {
                        head = runner.next;
                    }
                    if (runner.next != null) {
                        runner.next.prev = runner.prev;
                    } else {
                        tail = runner.prev;
                    }
                    removed = true;
                }
                runner = nextNode;
            }
            temp = temp.next;
        }
        System.out.println(removed ? "Duplicate removed." : "No duplicates found.");
    }

    public static void menu(Scanner sc) {
        DoublyLinkedList list = new DoublyLinkedList();
        int choice;
        do {
            System.out.println("\n********** Operation on Doubly Linked List **********");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");
 
            System.out.print("Enter the choice:- ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
                choice = -1;
            }

            switch (choice) {
 
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3: {
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.insertAtPosition(val, pos);
                    break;
                }
                case 4: {
                    System.out.print("Insert after which value: ");
                    int afterTarget = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int afterVal = sc.nextInt();
                    list.insertAfterNode(afterVal, afterTarget);
                    break;
                }
                case 5: {
                    System.out.print("Insert before which value: ");
                    int beforeTarget = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int beforeVal = sc.nextInt();
                    list.insertBeforeNode(beforeVal, beforeTarget);
                    break;
                }
                case 6:
                    list.deleteFromBeginning();
                    break;
                case 7:
                    list.deleteFromEnd();
                    break;
                case 8:
                    System.out.print("Delete which position: ");
                    list.deleteFromPosition(sc.nextInt());
                    break;
                case 9:
                    System.out.print("Delete which value: ");
                    list.deleteByValue(sc.nextInt());
                    break;
                case 10:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;
                case 11: {
                    System.out.print("Enter value to update: ");
                    int oldVal = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newVal = sc.nextInt();
                    list.update(oldVal, newVal);
                    break;
                }
                case 12:
                    list.displayForward();
                    break;
                case 13:
                    list.displayBackward();
                    break;
                case 14:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 15:
                    list.findMax();
                    break;
                case 16:
                    list.findMin();
                    break;
                case 17:
                    list.findMiddle();
                    break;
                case 18:
                    list.reverse();
                    break;
                case 19:
                    list.sort();
                    break;
                case 20:
                    list.removeDuplicates();
                    break;
                case 21:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
                } 
        } while (choice != 21);
    }
}