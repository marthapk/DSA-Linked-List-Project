import java.util.Scanner;

public class Main {
    
    public static void compare() {
        System.out.println("\n===== SINGLY vs DOUBLY LINKED LIST =====");
 
        System.out.println("\nSingly Linked List:");
        System.out.println("- Each node has 1 pointer (next)");
        System.out.println("- Can move forward only");
        System.out.println("- Uses less memory");
        System.out.println("- Delete from end is O(n)");
        System.out.println("- Simpler to write");
 
        System.out.println("\nDoubly Linked List:");
        System.out.println("- Each node has 2 pointers (prev and next)");
        System.out.println("- Can move forward and backward");
        System.out.println("- Uses more memory");
        System.out.println("- Delete from end is O(1) with a tail");
        System.out.println("- More pointers to manage");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n==================================================");
            System.out.println("        LINKED LIST MANAGEMENT SYSTEM");
            System.out.println("==================================================");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Compare Singly vs Doubly Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    SinglyLinkedList.menu(sc);
                    break;
                case 2:
                    DoublyLinkedList.menu(sc);
                    break;
                case 3:
                    compare();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

}
