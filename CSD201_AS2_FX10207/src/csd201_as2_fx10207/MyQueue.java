/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

/**
 *
 * @author Admin
 * @param <Product>
 */
public class MyQueue<Product> {
    protected Node front, rear;

    /**
     * @constructor
     */
    public MyQueue() {
        this.front = this.rear = null;
    }
    
    /**
     * @description checking a queue is empty
     * @return true/false
     */
    public boolean isEmpty() {
        return (this.front == null);
    }
    
    /**
     * @description show data of head Node
     * @return data of head
     * @throws Exception
     */
    public Product peek() throws Exception{
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            throw new Exception();
        }
        return (Product) this.front.info;
    }
    
    /**
     * @description add new Node from tail
     * @param newProduct - data of new Node
     */
    public void enqueue(Product newProduct) {
        if (isEmpty()) {
            this.front = this.rear = new Node(newProduct);
        } else {
            rear.nextNode = new Node(newProduct);
            rear = rear.nextNode;
        }
    }
    
    /**
     * @description delete a Node from head
     * @return data of head Node
     * @throws Exception - when queue is empty
     */
    public Product dequeue() throws Exception{
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            throw new Exception();
        }
        Product productOut = (Product) front.info;
        front = front.nextNode;
        if (front == null) {
            rear = null;
            System.out.println("Queue is empty now!");
        }
        return productOut;
    }
    
    /**
     * @description display all items in queue
     */
    public void showProductList() {
        Node browser = this.front;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","Price", "|","Stock\n");
        System.out.println("-------------------------------------------------");
        while (browser != null) {
            System.out.println(browser.info);
            browser = browser.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }
    
}
