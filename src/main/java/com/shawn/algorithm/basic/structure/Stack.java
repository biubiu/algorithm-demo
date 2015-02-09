package com.shawn.algorithm.basic.structure;

/**
 * @author Shawn Cao
 */
public interface Stack<T> extends Iterable<T>{

    /**
     * push one element into the stack
     * @param t
     */
    public void push(T t);

    /**
     * return the last insert element and delete it from the stack
     * @return T t
     */
    public T pop();

    /**
     * return the last inserted item without removing it from the stack
     * @return T
     */
    public T peek();

    /**
     * the used size the current stack
     * @return int
     */
    public int size();

    /**
     * whether the stack has elements
     * @return  boolean
     */
    public boolean isEmpty();
}
