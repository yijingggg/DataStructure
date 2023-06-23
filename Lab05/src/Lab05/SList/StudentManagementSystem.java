package Lab05.SList;

import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        String input;
        while (!(input = sc.nextLine()).equals("n"))
            list.add(input);
        System.out.println();

        System.out.println("You have entered the following students' name :");
        list.printList();
        System.out.println();

        System.out.println("The number of students entered is : " + list.getSize());
        System.out.println();

        System.out.println("All the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        input = sc.nextLine();
        System.out.println();

        if (input.equals("r")) {
            System.out.println("Enter the existing student name that u want to rename : ");
            String oldName = sc.nextLine();
            System.out.println();
            System.out.println("Enter the new name : ");
            String newName = sc.nextLine();
            System.out.println();
            list.replace(oldName, newName);
            System.out.println("The new student list is : ");
            list.printList();
            System.out.println();
        }

        System.out.println("Do you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        System.out.println();

        if (input.equals("y")) {
            System.out.println("Enter a student name to remove :");
            String name = sc.nextLine();
            list.removeElement(name);
            System.out.println();

            System.out.println("The number of updated student is : " + list.getSize());
            System.out.println("The updated students list is :");
            list.printList();
            System.out.println();
        }

        System.out.println("All student data captured complete. Thank you!");
    }
}

class SinglyLinkedList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public void add(E e) {
        if (tail == null) {
            head = tail = new SNode<>(e);
        } else {
            tail.next = new SNode<>(e);
            tail = tail.next;
        }
        size++;
    }

    public void removeElement(E e) {
        if (head == null) {
            return;
        }

        SNode<E> current;
        if (head.e.equals(e)) {
            current = head;
            head = head.next;
        } else {
            SNode<E> prev = head;
            while (!prev.next.e.equals(e)) {
                prev = prev.next;
            }
            current = prev.next;
            prev.next = current.next;
        }
        size--;
        System.out.println(current.e);
    }

    public void printList() {
        SNode<E> current = head;
        String separator = "";
        while (current != null) {
            System.out.print(separator + current.e);
            current = current.next;
            separator = ", ";
        }
        System.out.println(".");
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        SNode<E> current = head;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace(E e, E newE) {
        SNode<E> current = head;
        while (!current.e.equals(e)) {
            current = current.next;
        }
        current.e = newE;
    }
}

