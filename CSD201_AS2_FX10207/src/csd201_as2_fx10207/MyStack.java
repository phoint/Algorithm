/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 * @param <Product>
 */
public class MyStack<Product> {
    protected Node head;

    /**
     * @constructor
     */
    public MyStack() {
        this.head = null;
    }
    
    /**
     * @description checking empty stack
     * @return true/false
     */
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    /**
     * @description add new Node at head
     * @param newProduct - data of new Node
     */
    public void push(Product newProduct) {
        this.head = new Node(newProduct, head);
    }
    
    /**
     * @description delete a Node from head
     * @return - data of deleted Node
     * @throws EmptyStackException - when stack is empty
     */
    public Product pop() throws EmptyStackException {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            throw new EmptyStackException();
            
        }
            Product productOut = (Product) this.head.info;
            head = head.nextNode;
            return productOut;
        }
    
    /**
     * @description - display data of head
     * @return - data of head
     * @throws EmptyStackException
     */
    public Product peek() throws EmptyStackException {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            throw new EmptyStackException();
        }
        return (Product) head.info;
    }
    
    /**
     * @description display all  item from stack
     */
    public void showProductList() {
        Node browser = this.head;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","Price", "|","Stock\n");
        System.out.println("-------------------------------------------------");
        while (browser != null) {
            System.out.println(browser.info);
            browser = browser.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }
}
