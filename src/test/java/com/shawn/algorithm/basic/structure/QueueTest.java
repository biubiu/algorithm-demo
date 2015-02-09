package com.shawn.algorithm.basic.structure;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueueTest {

    @Test
    public void testQueueOperations(){
        Queue<Integer> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(10);
        assertEquals(3,queue.size());
        assertEquals(1,(int)queue.dequeue());
        assertEquals(2,(int)queue.dequeue());
        assertEquals(1,queue.size());
        assertFalse(queue.isEmpty());
        assertEquals(10,(int)queue.dequeue());
    }

    @Test
    public void testQueueIterator(){
        Queue<Integer> queue = new LinkedListQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        Iterator<Integer> it = queue.iterator();
        assertTrue(it.hasNext());
        assertEquals(10, (int) it.next());
        assertTrue(it.hasNext());
        assertEquals(20, (int) it.next());
        assertTrue(it.hasNext());
        assertEquals(30,(int)it.next());
        assertFalse(it.hasNext());
    }
}