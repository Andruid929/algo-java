package com.thealgorithms.stacks;

import java.util.NoSuchElementException;

/**
 * Implementation of a {@link java.util.Stack Stack} that uses a "singly" linked list
 * to mimic the Last In First Out (LIFO) behaviour of the Stack.
 * <p>
 * Singly meaning the implementation only tracks the elements behind it and not both
 * ways as the {@link java.util.LinkedList LinkedList} does.
 * <p>
 * <p>
 * Supports {@link #peek()}, {@link #pop()}, {@link #push(Object) push()},
 * checking if the structure is {@link #isEmpty()} and getting the {@link #size()}.
 *
 * @author Andruid929 (Andrew Jones)
 */
public class StackUsingLinkedList<T> {

    /**
     * The node at the top of the Stack (last inserted). If not null, contains the last inserted element
     *
     */
    private Node top;

    /**
     * The size of the LinkedStack
     *
     */
    private int size;

    /**
     * Creates a new instance of the Stack.
     *
     */

    public StackUsingLinkedList() {
    }

    /**
     * Check the element last inserted into the stack.
     *
     * @return the element last inserted into the Stack or {@code null} if the Stack is empty
     *
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return top.element;
    }

    /**
     * Removes an element from the Stack and then returns the removed element.
     *
     * @return the element last inserted into the Stack.
     * @throws NoSuchElementException if the Stack is empty.
     *
     */
    public T pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T removed = top.element; //Get the last inserted element before removing it

        top = top.next; //Set the second to last element at the top

        size--;

        return removed;
    }

    /**
     * Add a new element to the Stack.
     *
     * @param element the element to be added.
     *
     */
    public void push(T element) {
        Node node = new Node(element);

        Node next;

        if (top != null) {
            next = top; //Save the current top node

            top = node; //Update the newest node

            top.next = next; //Make the new node point to the old node
        } else {

            top = node;
        }

        size++;
    }

    /**
     * Check if the stack is empty.
     *
     * @return true if the Stack is empty; otherwise false.
     *
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Get the size stored within this Stack
     *
     * @return number of elements held in this Stack
     *
     */
    public int size() {
        return size;
    }

    /**
     * A simple wrapper holding an element and the element that is next to it.
     *
     */
    private class Node {

        /**
         * The element at this node.
         * */
        T element;

        /**
         * The node next to this one
         * */
        Node next;

        /**
         * Constructs a new node storing the given element and a null neighbour.
         *
         * @param element the element to be in this node.
         * */
        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
