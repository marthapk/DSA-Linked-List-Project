import java.util.Scanner;

public class SinglyLinkedList {
    
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    node head;

    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void insertAtBeginning(int data) {

        node newNode = new node(data);
        newNode.next = head;
        head = newNode;
        System.out.println(data + " inserted at beginning.");
    }

    public void insertAtEnd(int data) {
        
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
        } 
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(data + " inserted at end.");
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
        node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        node newNode = new node (data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data + " inserted at position " + position);
    }

    public void insertAfterNode(int data, int target) {

        node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Target node not found");
            return;
        }
        node newNode = new node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data + " inserted after " + target);
    }

    public void insertBeforeNode(int data, int target) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }
        node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Target node not found");
            return;
        }
        node newNode = new node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(data + " inserted before " + target);
    }

    public void deleteFromBeginning() {

        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        System.out.println(head.data + " deleted from beginning.");
        head = head.next;
    }

    public void deleteFromEnd() {

        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data + " deleted from end.");
            head = null;
            return;
        }
        node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.next.data + " deleted from end.");
        temp.next = null;
    }

    public void deleteFromPosition(int position) {

        if (head == null) {
            System.out.println("List empty. Nothing to delete.");
            return;
        }
        int size = countNodes();
        if (position < 1 || position > size) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        System.out.println(temp.next.data + " deleted from position " + position);
        temp.next = temp.next.next;
    }

    public void deleteByValue(int data) {

        if (head == null) {
            System.out.println("List empty. Nothing to delete.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted.");
            return;
        }
        
        node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println(data + " not found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println(data + " deleted.");
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

    public void update(int oldData, int newData) {

        node temp = head;
        while (temp != null) {
            if (temp.data == oldData) {
                temp.data = newData;
                System.out.println(oldData + " updated to " + newData);
                return;
            }
            temp = temp.next;
        }
        System.out.println(oldData + " not found in list.");
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
            System.out.println("List empty.");
            return;
        }
        int max = head.data;
        node temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Maximum value: " + max);
    }

    public void findMin() {
        
        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        int min = head.data;
        node temp = head.next;
        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }
        System.out.println("Minimum value: " + min);
    }

    public void findMiddle() {

        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }

    public void reverse() {

        node prev = null;
        node curr = head;
        node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
            node runner = temp;
            while (runner.next != null) {
                if (runner.next.data == temp.data) {
                    runner.next = runner.next.next;
                    removed = true;
                } else {
                    runner = runner.next;
                }
            }
            temp = temp.next;
        }
        System.out.println(removed ? "Duplicate removed." : "No duplicates found.");
    }

    public static void menu(Scanner sc) {
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;
        do {
            System.out.println("\n********** Operation on Singly Linked List **********");
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
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Exit");

            System.out.print("Enter the choice:- ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();      
                choice = -1;    
            }
            
            switch(choice) {

                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.insertAtPosition(val, pos);
                    break;
                case 4:
                    System.out.print("Insert after which value: ");
                    int target = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int afterVal = sc.nextInt();
                    list.insertAfterNode(afterVal, target);
                    break;
                case 5:
                    System.out.print("Insert before which value: ");
                    int target1 = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int val1 = sc.nextInt();
                    list.insertBeforeNode(val1, target1);
                    break;
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
                case 11:
                    System.out.print("Enter value to update: ");
                    int oldVal = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newVal = sc.nextInt();
                    list.update(oldVal, newVal);
                    break;
                case 12:
                    list.display();
                    break;
                case 13:
                    System.out.println("Number of nodes: " + list.countNodes());
                    break;
                case 14:
                    list.findMax();
                    break;
                case 15:
                    list.findMin();
                    break;
                case 16:
                    list.findMiddle();
                    break;
                case 17:
                    list.reverse();
                    break;
                case 18:
                    list.sort();
                    break;
                case 19:
                    list.removeDuplicates();
                    break;
                case 20:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 20);
    }

}
