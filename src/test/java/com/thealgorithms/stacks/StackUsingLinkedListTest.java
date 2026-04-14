package com.thealgorithms.stacks;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackUsingLinkedListTest {

    private StackUsingLinkedList<Integer> linkedStack;

    @BeforeEach
    public void instantiateLinkedStack() {
        linkedStack = new StackUsingLinkedList<>();
    }

    @Test
    void peek() {
        Assertions.assertNull(linkedStack.peek());

        linkedStack.push(10);
        linkedStack.push(20);
        linkedStack.push(30);

        Assertions.assertEquals(30, linkedStack.peek());
    }

    @Test
    void pop() {
        linkedStack.push(3);
        linkedStack.push(6);

        Assertions.assertEquals(6, linkedStack.pop());
        Assertions.assertEquals(3, linkedStack.peek());

        linkedStack.pop();

        Assertions.assertThrows(NoSuchElementException.class, () -> linkedStack.pop()); // Cannot pop from an empty stack
    }

    @Test
    void push() {
        linkedStack.push(12);

        Assertions.assertEquals(12, linkedStack.peek());

        linkedStack.push(15);
        linkedStack.push(17);

        Assertions.assertEquals(17, linkedStack.peek());
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(linkedStack.isEmpty());

        linkedStack.push(1);

        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void size() {
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);

        Assertions.assertEquals(4, linkedStack.size());

        linkedStack.pop();
        linkedStack.pop();

        Assertions.assertEquals(2, linkedStack.size());
    }
}
