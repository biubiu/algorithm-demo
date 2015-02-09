package com.shawn.algorithm.basic.structure;

import java.util.Iterator;


/**
 * @author Shawn Cao
 */
public class LinkedListStack<T> implements Stack<T> {
    private int size;
    private Node<T> first;

    @Override
    public void push(T t) {
        if(first == null){
            first = new Node(null,t,null) ;
        }
        else{
            Node<T> oldFirst = first;
            first = new Node<>(null,t,oldFirst);
            oldFirst.prev = oldFirst;
        }
        size++;
    }

    @Override
    public T pop() {
        if(first == null){
            return null;
        } else {
            T t = first.item;
            first = first.next;
            size --;
            return t;
        }


    }

    @Override
    public T peek() {
        if(first !=null)
            return first.item;
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListStackIterator<>(size,first);
    }

    private final static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedListStackIterator<T> implements Iterator<T>{
        int currentSize;
        Node<T> node;

        public LinkedListStackIterator(int currentSize, Node<T> node) {
            this.currentSize = currentSize;
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return currentSize > 0?true:false;
        }

        @Override
        public T next() {
            if(node != null){
                T t = node.item;
                node = node.next;
                currentSize --;
                return t;
            }
            return null;
        }
    }


}
