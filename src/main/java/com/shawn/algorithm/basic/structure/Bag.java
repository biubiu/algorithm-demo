package com.shawn.algorithm.basic.structure;

import java.util.Iterator;

/**
 *
 * @author Shawn cao
 *
 */
public class Bag<T> implements Iterable<T> {

    /**
     * add one item into bag
     * @param T t
     */
    public void add(T t){

    }

    /**
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return  false;
    }

    public int size(){
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
