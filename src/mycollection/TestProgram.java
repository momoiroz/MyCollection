/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycollection;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class TestProgram {

    private static LinkedList<Books> bl;

    public static void main(String[] args) {
        addFiveBooksToTheList();
        System.out.println("Initial list:");
        printList();
        System.out.println("---------------");
        System.out.println("Adding book to the list");
        bl.add(new Books(122, "Principles of Biochemistry", 1970));
        System.out.println("After adding list: ");
        printList();
        System.out.println("---------------");
        System.out.println("After sorting list by number (ascending order) ");
        {Collections.sort(bl);
        printList();}
        System.out.println("---------------");
        System.out.println("Change a book");
        if(bookChange()){
            System.out.println("New list:");
            printList();
        }
        System.out.println("---------------");
        System.out.println("Delete a book");
        if (bookDelete()){
            System.out.println("New list:");
            printList();
        }
    }

    public static void addFiveBooksToTheList() {
        bl = new LinkedList();
        bl.add(new Books(211, "ノルウェイの森", 1987));
        bl.add(new Books(121, "Ready Player One", 2011));
        bl.add(new Books(511, "Harry Potter and the Philosopher's Stone", 1997));
        bl.add(new Books(111, "Rich dad, poor dad", 2000));
        bl.add(new Books(411, "The Alchemist", 1988));
    }

    public static void printList() {
        for (Books b : bl) {
            System.out.println(b.toString());
        }
    }

    public static boolean bookChange() {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        do {
            try {
                System.out.print("Please input book's number: ");
                int number = sc.nextInt();
                int index = findBook(number);
                if (index == -1) {
                    System.out.println("No book found. Abort...");
                    return false;
                } else {
                    System.out.print("Input name: ");
                    sc.nextLine(); //flush
                    String name = sc.nextLine();
                    System.out.print("Input number: ");
                    int num = sc.nextInt();
                    System.out.print("Input year: ");
                    int year = sc.nextInt();
                    bl.set(index, new Books(num, name, year));
                    done = true;
                }
            } catch (Exception e) {
                if (e instanceof InputMismatchException)
                {
                    System.out.println("Input data type is wrong, please try again");
                }
                sc.nextLine();//flush
            }
        } while (!done);
        return true;
    }
    public static boolean bookDelete(){
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        do {
             try {
                System.out.print("Please input book's number: ");
                int number = sc.nextInt();
                int index = findBook(number);
                if (index == -1) {
                    System.out.println("No book found. Abort...");
                    return false;
                } else {
                   bl.remove(index);
                    done = true;
                }
            } catch (Exception e) {
                if (e instanceof InputMismatchException)
                {
                    System.out.println("Input data type is wrong, please try again");
                }
                sc.nextLine();//flush
            }
        }while(!done);
        return true;
    }

    public static int findBook(int number) {
        for (int i = 0; i < bl.size(); i++) {
            if (bl.get(i).getNumber() == number) {
                return i;
            }
        }
        return -1;
    }
}
