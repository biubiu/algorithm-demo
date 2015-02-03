package com.shawn.algorithm.basic.structure;

import java.util.Iterator;

/**
 * The class is to implement the Stack,
 * with the structure of 'Last in First out'
 *
 * @author Shawn cao
 *
 */
public class Stack<T> implements Iterable<T>{

    /**
      *
      * @param T item
     */
    public void push(T t){

    }

    /**
     *
     * @return T item
     */
    public T pop(){
        return null;
    }

    /**
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * the size of the Stack
     * @return int size
     */
    public int size(){
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
