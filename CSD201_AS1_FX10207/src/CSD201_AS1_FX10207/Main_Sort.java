/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_AS1_FX10207;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class Main_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Scanner sc = new Scanner(System.in);
        float[] inputArr;
        float[] originArr = null;
        int choice = -1;
        float searchKey;
        double start, end;
                
        while(true) {
            System.out.println("+--------------------Menu----------+");
            System.out.printf("%-10s%-25s%s","|","1.Input","|\n");
            System.out.printf("%-10s%-25s%s","|","2.Output","|\n");
            System.out.printf("%-10s%-25s%s","|","3.Bubble sort","|\n");
            System.out.printf("%-10s%-25s%s","|","4.Selection sort","|\n");
            System.out.printf("%-10s%-25s%s","|","5.Insertion sort","|\n");
            System.out.printf("%-10s%-25s%s","|","6.Search > value","|\n");
            System.out.printf("%-10s%-25s%s","|","7.Search = value","|\n");
            System.out.printf("%-10s%-25s%s","|","0.Exit","|\n");
            System.out.println("+----------------------------------+");
            System.out.print("Your choice (number 0 -> 7): ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ex) {
                sc.nextLine();
            }
            if (choice == 0){
                System.out.println("Thanks!");
                break;
            }
            
            switch(choice){
                case 1:
                    inputArr = Algorithm.takeInput();
                    Algorithm.writeFile(inputArr, "input.txt", false);
                    break;
                case 2:
                    try {
                        System.out.println("Read from file");
                        System.out.println("Original Arr: ");
                        originArr = Algorithm.readFile();
                    } catch (FileNotFoundException ex) {
                        System.out.println("\nFile not found! Please choose 1 for creating first.");
                    } catch (IOException ex) {
                    Logger.getLogger(Main_Sort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 3:
                    try {
                        float[] bubbleSortArr = new float[originArr.length];
                        System.out.println("Bubble sort steps: ");
                        System.arraycopy(originArr, 0, bubbleSortArr, 0, originArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.bubbleSort(bubbleSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Bubble Sort's execution time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                        System.out.println("You might not get array from file, please choose 2 for getting array.");
                    }
                    break;
                case 4:
                    try {
                        float[] selectSortArr = new float[originArr.length];
                        System.out.println("Selection sort Steps: ");
                        System.arraycopy(originArr, 0, selectSortArr, 0, originArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.selectSort(selectSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Selection Sort's execution time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                        System.out.println("You might not get array from file, please choose 2 for getting array.");
                    }
                    break;
                case 5:
                    try {
                        float[] insertSortArr = new float[originArr.length];
                        System.out.println("Insertion sort Steps: ");
                        System.arraycopy(originArr, 0, insertSortArr, 0, originArr.length);
                        start = System.currentTimeMillis();
                        Algorithm.selectSort(insertSortArr, true);
                        end = System.currentTimeMillis();
                        System.out.println("Insertion Sort's execution time: " + (end-start) +" ms");
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                        System.out.println("You might not get array from file, please choose 2 for getting array.");
                    }
                    break;
                case 6:
                    System.out.println("Linear search: ");
                    System.out.print("Search key: ");
                    searchKey = sc.nextFloat();
                    System.out.print("Indexies: ");
                    try {
                        Algorithm.search(originArr, searchKey);
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                        System.out.println("You might not get array from file, please choose 2 for getting array.");                        
                    }
                    break;
                case 7:
                    System.out.println("Binary search: ");
                    System.out.print("Search key: ");
                    searchKey = sc.nextFloat();
                    System.out.print("Index: ");
                    try {
                    Algorithm.binarySearch(originArr, searchKey);
                    } catch (NullPointerException ex) {
                        System.out.println("\nArray is null!");
                        System.out.println("You might not get array from file, please choose 2 for getting array.");
                    }
                    break;
                default:
                    System.out.println("**Invalid choice. Please try again**");                          
            }
        }      
    } 
}
