package com.shawn.algorithm.basic.structure;

import java.util.Iterator;

/**
 * The class is to implement a simple queue data structure
 * in accordance to the principle of 'First in First out'
 *
 * @author Shawn cao
 *
 */
public class Queue<T> implements  Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * push item into the queue, tail to the last item and the size will augment
     * @param T item
     */
    public void enqueue(T t){

    }

    /**
     * return is the queue is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * delete the top item in the queue and the size decrease by 1
     * @return T item
     */
    public T dequeue(){
        return null;
    }

    /**
     * return the size of the current queue
     * @return int
     */
    public int size(){
        return 0;
    }
}
