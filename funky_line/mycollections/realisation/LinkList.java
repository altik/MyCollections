package com.funky_line.mycollections.realisation;

import com.funky_line.mycollections.myinterface.Ilist;

/**
 * Created by Rudniev Oleksandr on 14.11.2016.
 */

public class LinkList<T> implements Ilist {

    private class Node {

        public Node next;
        public Node prev;
        public Object value;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node firstNode;
    private int size;

    public LinkList() {
        size = 0;
    }

    @Override
    public boolean add(Object o) {
        if (firstNode == null) {
            firstNode = new Node(o);
            size++;
        } else {
            Node pointer = firstNode;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            Node newNode = new Node(o);
            newNode.prev = pointer;
            pointer.next = newNode;
            size++;
        }
        return true;
    }

    private Node findNodeFromIndex(int index) {
        int pointerIndex = 0;
        Node pointer = firstNode;
        while (pointerIndex < index) {
            pointer = pointer.next;
            pointerIndex++;
        }
        return pointer;
    }


    @Override
    public boolean add(int i, Object value) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("size" + size + " index:" + i);
        }
        Node newNode = new Node(value);
        if (i == 0) {
            newNode.next = firstNode;
            if (firstNode != null) {
                firstNode.prev = newNode;
            }
            firstNode = newNode;
        } else if (i == size) {
            Node currentNode = findNodeFromIndex(i - 1);
            currentNode.next = newNode;
            newNode.prev = currentNode;
        } else {
            Node currentNode = findNodeFromIndex(i);
            currentNode.prev.next = newNode;
            newNode.prev = currentNode.prev;
            newNode.next = currentNode;
            currentNode.prev = newNode;

        }
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("size" + size + " index:" + index);
        }
        Node currentNode = findNodeFromIndex(index);
        Node previousNode = currentNode.prev;
        Node nextNode = currentNode.next;

        previousNode.next = currentNode.next;
        nextNode.prev = currentNode.prev;
        size--;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node pointer = firstNode;
        boolean result = false;
        if (pointer != null) {
            for (int i = 0; i <size(); i++) {
                if (get(i) == o);
                return true;
            }
                }


        return result;
    }

    @Override
    public Object get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("size:" + size + " index" + position);
        }
        Node pointer = findNodeFromIndex(position);
        return pointer.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void clear() {
        firstNode = null;
    }

    @Override
    public boolean set(int o, Object value) {
        if (o < 0 || o > size) {
            throw new IndexOutOfBoundsException("size:" + size + " index:" + o);
        }
        if (o == 0 && size == 0) {
            add(value);
        } else {
            Node currentNode = findNodeFromIndex(o);
            Node newNode = new Node(value);
            newNode.next = currentNode.next;
            if (currentNode.prev != null) {
                newNode.prev = currentNode.prev;
                currentNode.prev.next = newNode;
            }
            if (o == 0) {
                firstNode = newNode;
            }
        }
        return true;
    }

}
