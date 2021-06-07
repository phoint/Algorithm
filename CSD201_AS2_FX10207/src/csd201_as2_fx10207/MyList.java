/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

/**
 *
 * @author Admin
 * @param <Product> - a product from class Product
 */
public class MyList<Product> {

    Node<Product> head, tail;

    public MyList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    /**
     * @description add new Node from head
     * @param x - data of new Node
     */
    public void addHead(Product x) {
        Node<Product> newProduct = new Node(x);
        if (isEmpty()) {
            this.head = this.tail = newProduct;
        } else {
            newProduct.nextNode = this.head;
            this.head = newProduct;
        }
    }

    /**
     * @description add new Node to any position in LinkedList
     * @param position - the position for new Node
     * @param x - data of new Node
     */
    public void insertAfterPosition(int position, Product x) {
        Node<Product> newProduct = new Node(x);
        if (position == 0) {
            addHead(x);
        } else if (position > this.size()) {
            System.out.println("Position is out of this LinkedList");
        } else if (position == this.size()) {
            addTail(x);
        } else {
            Node<Product> holeposition = this.head;
            for (int i = 0; i < position - 1; i++) {
                holeposition = holeposition.nextNode;
            }
            newProduct.nextNode = holeposition.nextNode;
            holeposition.nextNode = newProduct;
        }
    }

    /**
     * @description delete one Node at end of LinkedList
     * @throws Exception - when Linkedlist empty
     */
    public void deleteTail() throws Exception {
        if (isEmpty()) {
            System.out.println("This LinkedList is empty!");
            throw new Exception();
        }
        Node<Product> browser = this.head;
        for (int i = 1; i < (this.size() - 1); i++) {
            browser = browser.nextNode;
        }
        this.tail = browser;
        browser.nextNode = null;
    }

    /**
     * @description delete any Node which has data similar to x
     * @param x - data of new Node
     * @throws Exception - when LinkedList is empty
     */
    public void deleteElement(Product x) throws Exception {
        if (isEmpty()) {
            System.out.println("This LinkedList is empty!");
            throw new Exception();
        }
        Node<Product> browser = this.head;
        if (this.head.info.equals(x)) {
            this.head = head.nextNode;
        } else {
            while (browser.nextNode != null) {
                if (browser.nextNode.info.equals(x)) {
                    Node<Product> holder = browser.nextNode;
                    browser.nextNode = holder.nextNode;
                } else {
                    browser = browser.nextNode;
                }

            }
        }

    }

    /**
     * @description swap position of two Node
     * @param front - first Node need swapping
     * @param back - second Node need swapping
     */
    public void swap(Node<Product> front, Node<Product> back) {
        Product temp;
        temp = front.info;
        front.info = back.info;
        back.info = temp;
    }

    /**
     * @description clear all Node from LinkedList
     */
    public void clear() {
        this.head = this.tail = null;
    }

    /**
     * @description add new Node from the end of LinkedList
     * @param x - data of new Node
     */
    public void addTail(Product x) {
        Node newProduct = new Node(x);
        if (isEmpty()) {
            this.head = this.tail = newProduct;
        } else {
            this.tail.nextNode = newProduct;
            this.tail = newProduct;
        }
    }

    /**
     * @décription add more than 1 Node to LinkedList
     * @param productArr - an Array of data will be add to LinkedList
     */
    public void addMany(Product[] productArr) {
        for (Product product : productArr) {
            addTail(product);
        }
    }

    /**
     * @description calculate the size of LinkedList
     * @return count - number of item in list
     */
    public int size() {
        int count = 0;
        Node<Product> browser = this.head;
        while (browser != null) {
            count++;
            browser = browser.nextNode;
        }
        return count;
    }

    /**
     * @description display all product in LinkedList to console screen
     */
    public void showProductList() {
        Node oneProduct = this.head;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","Price", "|","Stock\n");
        System.out.println("-------------------------------------------------");
        while (oneProduct != null) {
            System.out.println(oneProduct.info);
            oneProduct = oneProduct.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }

}
