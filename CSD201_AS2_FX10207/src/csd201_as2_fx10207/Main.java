/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Main {
    
    /**
     * @description print the menu of program
     */
    public static void showMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("Choose one of this options: ");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID");
        System.out.println("8. Convert to binary");
        System.out.println("9. Load to Stack and display");
        System.out.println("10. Load to Queue and display");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------");
        System.out.print("Please choose from (0 -> 10), ");
    }
    
    /**
     * @description set the standard out to print on console and to file
     */
    public static void setOutPrint() {
        try {
        //create output streams writing to file
	FileOutputStream fout= new FileOutputStream("console_output.txt");
	FileOutputStream ferr= new FileOutputStream("stderr.txt");
        
        //append all output stream to one stream
	MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
	MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
	
        //creat a print stream
	PrintStream stdout = new PrintStream(multiOut);
	PrintStream stderr= new PrintStream(multiErr);

	
        //set the standard output
	System.setOut(stdout);
	System.setErr(stderr);
    } catch (FileNotFoundException ex) {
        //Could not create/open the file
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setOutPrint();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        MyList<Product> myList = new MyList();
        MyStack<Product> myStack = new MyStack();
        MyQueue<Product> myQueue = new MyQueue();
        
        //make the program repeat until the choice is 0(exit)
        while (true) {
            showMenu();
            
            //take input of choice. If not valid, asking another input
            do {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    System.out.println("Your choice: " + choice);
                    break;
                } else {
                    sc.nextLine();
                    System.out.print("Input must be number (from 0 -> 10): ");
                }
            } while (sc.hasNext());
            if (choice == 0) {
                System.out.println("Thanks!");
                break;
            }
            
            //choosing which task will be executed
            switch (choice) {
                case 1:
                    OperationToProduct.getAllItemsFromFile("Data.txt", myList);
                    System.out.println("List from file:");
                    OperationToProduct.displayAll(myList);
                    break;
                case 2:
                    System.out.println("Add new product: ");
                    OperationToProduct.addLast(myList);
                    break;
                case 3:
                    System.out.println("Product list:");
                    OperationToProduct.displayAll(myList);
                    break;
                case 4:
                    System.out.println("Write data to file!");
                    OperationToProduct.writeAllItemsToFile("Data.txt", myList);
                    System.out.println("Completed!");
                    break;
                case 5:
                    OperationToProduct.searchByCode(myList);
                    break;
                case 6:
                    OperationToProduct.deleteByCode(myList);
                    break;
                case 7:
                    System.out.println("Sort product list by ID:");
                {
                    try {
                        OperationToProduct.sortByCode(myList, myList.head);
                        OperationToProduct.displayAll(myList);
                    } catch (Exception ex) {
                        System.out.println("This list is empty!");
                    }
                }
                    break;

                case 8:
                    int binaryNum = OperationToProduct.convertBinary(myList.head.info.stock);
                    System.out.println("Stock in binary: " + binaryNum);
                    break;
                case 9:
                    System.out.println("List product from Stack:");
                    OperationToProduct.getAllItemsFromFile("Data.txt", myStack);
                    OperationToProduct.displayAll(myStack);
                    break;
                case 10:
                    System.out.println("List product from Queue:");
                    OperationToProduct.getAllItemsFromFile("Data.txt", myQueue);
                    OperationToProduct.displayAll(myQueue);
                    break;
                default:
                    System.out.println("**Invalid choice. Please try again**");
            }
        
        }
    }
    
}
