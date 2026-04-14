package com.thealgorithms.stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class StackUsingLinkedListTest {

    private StackUsingLinkedList<Integer> linkedStack;

    @BeforeEach
    public void instantiateLinkedStack() {
        linkedStack = new StackUsingLinkedList<>();
    }

    @Test
    void peek() {
        assertNull(linkedStack.peek());

        linkedStack.push(10);
        linkedStack.push(20);
        linkedStack.push(30);

        assertEquals(30, linkedStack.peek());
    }

    @Test
    void pop() {
        linkedStack.push(3);
        linkedStack.push(6);

        assertEquals(6, linkedStack.pop());
        assertEquals(3, linkedStack.peek());

        linkedStack.pop();

        assertThrows(NoSuchElementException.class, () -> linkedStack.pop()); //Cannot pop from an empty stack
    }

    @Test
    void push() {
        linkedStack.push(12);

        assertEquals(12, linkedStack.peek());

        linkedStack.push(15);
        linkedStack.push(17);

        assertEquals(17, linkedStack.peek());

    }

    @Test
    void isEmpty() {
        assertTrue(linkedStack.isEmpty());

        linkedStack.push(1);

        assertFalse(linkedStack.isEmpty());
    }

    @Test
    void size() {
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);

        assertEquals(4, linkedStack.size());

        linkedStack.pop();
        linkedStack.pop();

        assertEquals(2, linkedStack.size());
    }
}