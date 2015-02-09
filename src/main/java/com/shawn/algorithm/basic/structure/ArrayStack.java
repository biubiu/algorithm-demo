package com.shawn.algorithm.basic.structure;

import java.util.Iterator;

/**
 * The class is the implement of Stack(FIFO) by using array,
 * resizing by twice of the origin when capacity is not enough and shrunking by one twice if only using
 * one fourth of the space.
 * @author Shawn cao
 *
 */
public class ArrayStack<T> implements Stack<T>{

    T[] stackArray;

    final int DEFAULT_SIZE = 16;
    int currentSize;
    public ArrayStack() {
        stackArray = (T[])new Object[DEFAULT_SIZE];
    }

    /**
     * initialize stack with size
     * @param size
     */
    public ArrayStack(int size){
        stackArray = (T[]) new Object[size];
    }

    /**
      *
      * @param T
     */
    public void push(T t){
        if(t != null) {
            checkCapacity();
            stackArray[currentSize++] = t;
        }
    }

    private void checkCapacity() {
        if(currentSize + 1 > stackArray.length){
            resize(stackArray.length * 2);
        }
    }


    private void resize(int max){
        T[] temp = (T[])new Object[max];
        for(int i=0; i < currentSize; i++){
            temp[i] = stackArray[i];
        }
        stackArray = temp;
    }

    /**
     *
     * @return T item
     */
    public T pop(){
        if(currentSize > 0) {
            T t =  stackArray[--currentSize];
            stackArray[currentSize] = null;
            if(currentSize == stackArray.length/4){
                resize(stackArray.length/2);
            }
            return t;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public T peek() {
        if(currentSize > 0)
            return stackArray[currentSize];
        return null;
    }

    /**
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * the size of the Stack
     * @return int size
     */
    public int size(){
        return currentSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator<T>();
    }

    private class ReverseArrayIterator<T> implements Iterator<T>{
        private int size = currentSize;
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            return (T)stackArray[--size];
        }

    }
}
