/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_AS1_FX10207;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Algorithm {

//    private float[] numberLs;
//    private int len;
    public Algorithm() {
    }

//    public Algorithm(float[] inputLs) {
//        this.len = inputLs.length;
//        this.numberLs = new float[len];
//        System.arraycopy(inputLs, 0, numberLs, 0, len);
//    }

    /**
     * @description Display an array to formatted string
     * @param arr - an array will be displayed in string formatted
     */

    public static void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * @description Ask user inputting for size and every value of an numeric array
     * @return numberLs - an array store input value for sorting later
     */
    public static float[] takeInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of elements: ");
        int len = 0;
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                len = input.nextInt();
                input.nextLine();
                break;
            } else {
                input.nextLine();
                System.out.print("Please type a number: ");
            }
        }
        float[] numberLs = new float[len];
        for (int i = 0; i < len; i++) {
            System.out.print("number " + (i + 1) + ": ");
            while (input.hasNext()) {
                if (input.hasNextFloat() || input.hasNextInt()) {
                    numberLs[i] = input.nextFloat();
                    input.nextLine();
                    break;
                } else {
                    input.nextLine();
                    System.out.print("Please type a number: ");
                }
            }
        }
        return numberLs;
    }

    /**
     * @description Write a float array to a file
     * @param numberLs - an array need to write to file
     * @param path - path to the file
     * @param append - overwrite or append to file
     */
    public static void writeFile(float[] numberLs, String path, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (float numberItem : numberLs) {
                bw.write(numberItem + "\t");
            }
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @description Write a String array to a file
     * @param numberLs - an array need to write to file
     * @param path - path to the file
     * @param append - overwrite or append to file
     */
    public static void writeFile(String[] numberLs, String path, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
                for (String numberItem : numberLs) {
                    bw.write(numberItem + "\t");
                }
                bw.newLine();
                bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }

    /**
     * @throws java.io.FileNotFoundException, java.io.IOException
     * @description Read a text file and return an array for sorting later
     * @return finalArray - an array is read from file
     */
    public static float[] readFile() throws FileNotFoundException, IOException {
        String[] holderArray;
        float[] finalArray;
        try (FileReader fr = new FileReader("input.txt")) {
            Scanner reader = new Scanner(fr);
            holderArray = reader.nextLine().split("\t");
            finalArray = new float[holderArray.length];
            for (int i = 0; i < holderArray.length; i++) {
                finalArray[i] = Float.parseFloat(holderArray[i]);
            }
        }
        display(finalArray);
        return finalArray;
    }

    /**
     * @description Swap two value in an array
     * @param i - position of a value in array will be swapped
     * @param k - position of a value in array will be swapped
     * @param arr - an array contains the value need swapping
     */
    public static void swap(int i, int k, float[] arr) {
        float x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }

    /**
     * @description Apply bubble sorting and write to file output1.txt
     * @param sorting - An array need sorting
     * @param displaySteps - Boolean for display steps of Algorithm or not
     */
    public static void bubbleSort(float[] sorting, boolean displaySteps) {
        for (int i = 0; i < sorting.length - 1; i++) {
            for (int j = 0; j < sorting.length - 1 - i; j++) {
                if (sorting[j] > sorting[j + 1]) {
                    swap(j, j + 1, sorting);
                }
            }
            if (displaySteps) {
                display(sorting);
            }
            if (i == 0) {
                writeFile(sorting, "output1.txt", false);
            } else {
                writeFile(sorting, "output1.txt", true);
            }
        }
    }

    /**
     * @description Apply select sorting and write to file output2.txt
     * @param sorting - An array need sorting
     * @param displaySteps - Boolean for display steps of Algorithm or not
     */
    public static void selectSort(float[] sorting, boolean displaySteps) {
        for (int i = 0; i < sorting.length - 1; i++) {
            var minPosition = i;
            for (int j = i + 1; j < sorting.length; j++) {
                if (sorting[j] < sorting[minPosition]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                swap(minPosition, i, sorting);
            }
            if (displaySteps) {
                display(sorting);                
            }
            if (i == 0) {
                writeFile(sorting, "output2.txt", false);
            } else {
                writeFile(sorting, "output2.txt", true);
            }
        }
    }
    
    /**
     * @description Apply insert sorting and write to file output3.txt
     * @param sorting - An array need sorting
     * @param displaySteps - Boolean for display steps of Algorithm or not
     */
    public static void insertSort(float[] sorting, boolean displaySteps) {
        for (int i = 1; i < sorting.length; i++) {
            int holePosition = i;
            float valueInserting = sorting[i];
            while (holePosition > 0 && sorting[holePosition - 1] > valueInserting) {
                sorting[holePosition] = sorting[holePosition - 1];
                holePosition--;
            }
            sorting[holePosition] = valueInserting;
            if (displaySteps) {
                display(sorting); 
            }
            if (i == 1) {
                writeFile(sorting, "output3.txt", false);
            } else {
                writeFile(sorting, "output3.txt", true);
            }
        }
    }

    /**
     * @description Apply linear searching for value greater or equal searchKey and write to file output4.txt
     * @param arr - An array for searching
     * @param searchKey - Value to find
     */
    public static void search(float[] arr, float searchKey) {
        String found = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= searchKey) {
                found = found.concat(i + "\t");
            }
        }
        if (!found.isEmpty()) {
            System.out.println(found);
            String[] foundArr = found.split("\t");
            writeFile(foundArr, "output4.txt", false);
        } else {
            String[] notFound = {"Nothing found"};
            System.out.println("Nothing found");
            writeFile(notFound, "output4.txt", false);
        }
    }

    /**
     * @description Apply binary searching and write to file output5.txt
     * @param arr - An array for searching
     * @param searchKey - Value to find
     * @return midPoint - position of matching value or -1 if nothing found in array
     */
    public static int binarySearch(float[] arr, float searchKey) {
        selectSort(arr, false);
        int lower = 0;
        int upper = arr.length;
        int midPoint;
        do {
            if (upper < lower) {
                break;
            }
            midPoint = lower + (upper - lower) / 2;
            if (arr[midPoint] > searchKey) {
                upper = midPoint - 1;
            } 
            if (arr[midPoint] < searchKey) {
                lower = midPoint + 1;
            } 
            if (searchKey == arr[midPoint]) {
                String[] foundArr = {(midPoint + "\t")};
                System.out.println(midPoint);
                writeFile(foundArr,"output5.txt", false);
                return midPoint;
            }
        } while (searchKey != arr[midPoint]);
        String[] notFound = {"Nothing found"};
        System.out.println("Nothing found");
        writeFile(notFound, "output5.txt", false);
        return -1;
    }
}
