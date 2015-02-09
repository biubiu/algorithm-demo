package com.shawn.algorithm.basic.structure;

import java.util.Iterator;

/**
 * @author Shawn Cao
 */
public class LinkedListQueue<E> implements Queue<E> {
    int size;
    Node<E> first;
    Node<E> last;

    /**
     * new node append to the last
     * @param e
     */
    @Override
    public void enqueue(E e) {
       if(first == null){
           first = new Node<>(null,null,e);
           last = first;
       } else {
           Node<E> prev = last;
           last = new Node<>(prev,null,e);
           prev.next = last;

       }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * return the fist node of the queue, and the second node becomes the first.
     * @return E e
     */
    @Override
    public E dequeue() {
        if(first == null) return null;
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator(first);
    }

     private final static class Node<E>{
        Node<E> prev;
         Node<E> next;
         E item;

         public Node(Node<E> prev, Node<E> next, E item) {
             this.prev = prev;
             this.next = next;
             this.item = item;
         }
     }


    private class LinkedListQueueIterator implements Iterator<E> {

        Node<E> first;

        public LinkedListQueueIterator( Node<E> first) {

            this.first = first;

        }

        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public E next() {
            E item = first.item;
            if(first.next != null) first = first.next;
            return item;
        }
    }
}
