/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

import java.io.BufferedReader;
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
public class OperationToProduct {

    /**
     * @description find index of Node has data p
     * @param p - data of Node
     * @param list - LinkedList of Product
     * @return - index of Node has data p
     */
    public static int index(Product p, MyList<Product> list) {
        if (list.isEmpty()) {
            return -1;
        }
        Node<Product> browser = list.head;
        for (int i = 0; i < list.size(); i++) {
            if (p.equals(browser.info)) {
                return i;
            } else {
                browser = browser.nextNode;
            }
        }
        return -1;
    }

    /**
     * @description creat a new Product with field input
     * @return new Product
     */
    public static Product createProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Id (in letter): ");
        String productId = input.next();
        System.out.print("Name (in letter): ");
        String productName = input.next();
        System.out.print("Price (in number): ");
        double productPrice = input.nextDouble();
        System.out.println("Stock (in number): ");
        int productStock = input.nextInt();
        return new Product(productId, productName, productPrice, productStock);
    }

    /**
     * @description read a product file and store all product to LinkedList
     * @param fileName - the file will be read
     * @param list - LinkedList will store all items
     */
    public static void getAllItemsFromFile(String fileName, MyList<Product> list) {
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), Integer.parseInt(productInfo[3]));
                list.addTail(newProduct);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }
    
    /**
     * @description overloading getAllItemsFromFile replacing with Stack
     * @param fileName - the file will be read
     * @param myStack - Stack will store all items
     */
    public static void getAllItemsFromFile(String fileName, MyStack<Product> myStack){
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), Integer.parseInt(productInfo[3]));
                myStack.push(newProduct);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }

    /**
     * @description overloading getAllItemsFromFile replacing with Queue
     * @param fileName
     * @param myQueue
     */
    public static void getAllItemsFromFile(String fileName, MyQueue<Product> myQueue) {
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1], Float.parseFloat(productInfo[2]), Integer.parseInt(productInfo[3]));
                myQueue.enqueue(newProduct);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }
    
    /**
     * @description creat new Product and append to LinkedList at tail.
     * @param list - LinkedList will append new product
     */
    public static void addLast(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        String isNext; 
        do {
            list.addTail(createProduct());
            System.out.print("Continue (Y/N)?");
            isNext = input.next();
        } while (isNext.equalsIgnoreCase("Y") || isNext.equalsIgnoreCase("yes"));
    }
    
    /**
     * @description print all item in LinkedList to screen
     * @param list - LinkedList will be browsed
     */
    public static void displayAll(MyList<Product> list) {
        list.showProductList();
    }

    /**
     * @description overloading displayAll replacing with Stack
     * @param stack
     */
    public static void displayAll(MyStack<Product> stack) {
        stack.showProductList();
    }

    /**
     * @description overloading displayAll replacing with Queue
     * @param queue
     */
    public static void displayAll(MyQueue<Product> queue) {
        queue.showProductList();
    }
    
    /**
     * @descripton write all items in LinkedList to file
     * @param filename - file will be written
     * @param list - LinkedList will be browsed
     */
    public static void writeAllItemsToFile(String filename, MyList<Product> list) {
        FileWriter fr;
        BufferedWriter bw;
        try {
            fr = new FileWriter(filename, false);
            bw = new BufferedWriter(fr); 
            Node<Product> oneProduct = list.head;
            Product holderProduct;
            while (oneProduct != null) {
                holderProduct = oneProduct.info;
                String productInfo = holderProduct.productId + "," +
                        holderProduct.productName + "," +
                        holderProduct.productPrice + "," +
                        holderProduct.stock;
                bw.write(productInfo);
                bw.newLine();
                oneProduct = oneProduct.nextNode;
            }
            bw.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @description browse a LinkedList and look for item has ID get from input
     * @param list - LinkedList will be browsed
     */
    public static void searchByCode(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        Node<Product> browser = list.head;
        System.out.print("Search by Id: ");
        String searchKey = input.next();
        boolean isFound = false;
        while (browser != null) {
            if (searchKey.equalsIgnoreCase(browser.info.productId)) {
                System.out.println("Product was found!");
                System.out.println(browser.info);
                isFound = true;
                break;
            } else {
                browser = browser.nextNode;                
            }
        }
        if (!isFound) {
            System.out.println("-1: Nothing found!");
        }
    }

    /**
     * @description browse LinkedList and delete item has ID similar to the input if found
     * @param list - LinkedList will be browsed
     */
    public static void deleteByCode(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        Node<Product> browser = list.head;
        System.out.print("Delete Id: ");
        String searchKey = input.next();
        boolean isFound = false;
        while (browser != null) {
            if (searchKey.equalsIgnoreCase(browser.info.productId)) {
                try {
                    list.deleteElement(browser.info);
                    System.out.println("Completed");
                    isFound = true;
                } catch (Exception ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            } else {
                browser = browser.nextNode;              
            }
        }
        if (!isFound) {
            System.out.println("The ID is not in this list");
        }
    }
    
    /**
     * @description create new item and add to head of LinkedList
     * @param list - LinkedList will append new items
     */
    public static void addFirst(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        String isNext; 
        do {
            list.addHead(createProduct());
            System.out.print("Continue (Y/N)?");
            isNext = input.next();
        } while (isNext.equalsIgnoreCase("Y") || isNext.equalsIgnoreCase("yes"));
    }
    
    /**
     * @description take an number and convert to binary
     * @param i - number would be converted
     * @return binary
     */
    public static int convertBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i%2 + 10*(convertBinary(i/2));
        }
    }
    
    /**
     * @description delete item at a position in LinkedList if the position is in LinkedList
     * @param list - LinkedList will be browsed
     */
    public static void deletePosition(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("delete Node at: ");
        int pos = input.nextInt();
        Node<Product> browser = list.head;
        while (browser != null) {
            if (pos > list.size() - 1) {
                System.out.println("The position is out of list!");
                break;
            }
            for (int i = 0; i <= pos; i++) {
                browser = browser.nextNode;
            }
            try {
                list.deleteElement(browser.info);
            } catch (Exception ex) {
                Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * @description sort LinkedList using recursive selection sort
     * @param list - LinkedList will be sorted
     * @param start - the starting Node for sorting
     * @throws Exception - when LinkedList is empty
     */
    public static void sortByCode(MyList<Product> list, Node<Product> start) throws Exception{
        if (list.isEmpty()) {
            throw new Exception();
        }
        if (start.nextNode == null) {
            return;
        }
        Node<Product> min = start.nextNode;
        while (min != null) {
            if (start.info.productId.compareToIgnoreCase(min.info.productId) > 0) {
                list.swap(start, min);
            }
            min = min.nextNode;
        }
        sortByCode(list, start.nextNode);
    }
}
