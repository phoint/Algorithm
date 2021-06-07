/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_fx10207;

/**
 *
 * @author Admin
 * @param <Product> - Node's data
 */
public class Node<Product> {
    Product info;
    Node nextNode;

    /**
     * @constructor
     */
    public Node() {
    }

    /**
     * @constructor overloading with two param
     * @param info - data of Node
     * @param nextNode - reference Node
     */
    public Node(Product info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    /**
     * @constructor overloading with one param
     * @param info - data of Node
     */
    public Node(Product info) {
        this(info,null);
    }

    @Override
    public String toString() {
        return "\n" + info;
    }
}
