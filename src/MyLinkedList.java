import java.util.Random;
public class MyLinkedList<T> implements MyList<T> {

    // inner class Node to hold each element and links to previous and next elements
    private class Node<T> {
        T elements;
        Node next;
        Node previous;

        public Node(T elements, Node next, Node previous) {
            this.elements = elements;
            this.next = null;
            this.previous = null;
        }
    }

    // member variables
    private Node head;   // reference to first node in the list
    private Node tail;   // reference to last node in the list
    private int size;    // number of elements in the list

    // constructor to initialize member variables
    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    // implementation of MyList interface methods

    // returns the number of elements in the list
    @Override
    public int size() {
        return size;
    }

    // returns true if the list contains the specified element, false otherwise
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.elements.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // adds the specified element to the end of the list
    // returns true if the element was added successfully
    @Override
    public boolean add(T item) {
        Node node = new Node(item, null, tail);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return false;
    }

    @Override
    public void addAll(T item) {

    }
    @Override
    public void addAll(Collection<? extends T> collection) {
        int collectionSize = collection.size();
        int minLength = size + collectionSize;
        if (minLength > arr.length) {
            int newCapacity = arr.length * 2;
            if (newCapacity < minLength) {
                newCapacity = minLength;
            }
            arr = Arrays.copyOf(arr, newCapacity);
        }
        for (T item : collection) {
            arr[size++] = item;
        }
    }

    // inserts the specified element at the specified index in the list
    // throws IndexOutOfBoundsException if index is out of range
    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node node = new Node(element, current, current.previous);
            current.previous.next = node;
            current.previous = node;
            size++;
        }
    }

    // removes the first occurrence of the specified element from the list
    // returns true if the element was removed successfully, false otherwise
    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (current.elements.equals(o)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else if (current == tail) {
                    tail = current.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) { // Check if index is out of bounds
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node current = head; // Start from the head node
        for (int i = 0; i < index; i++) { // Traverse the list until the index
            current = current.next;
        }
        // Remove the node at the index and adjust head and tail pointers if necessary
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (current == tail) {
            tail = current.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--; // Decrement the size of the list
        return (T) current.elements; // Return the element that was removed
    }

    @Override
    public void clear() {
        size = 0; // Set the size of the list to 0
        head = null; // Set head and tail pointers to null
        tail = null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) { // Check if index is out of bounds
            throw new IndexOutOfBoundsException();
        }
        Node current = head; // Start from the head node
        if (index < size / 2) { // If the index is in the first half of the list, traverse from the head
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else { // Otherwise, traverse from the tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return (T) current.elements; // Return the element at the index
    }

    @Override
    public int indexOf(Object o) {
        if (head == null) { // If the list is empty, return -1
            return -1;
        }
        return indexOfHelper(o, head, 0); // Call the helper method to find the index of the element
    }

    private int indexOfHelper(Object o, Node current, int index) {
        if (current == null) { // If the end of the list is reached, return -1
            return -1;
        }
        if (current.elements.equals(o)) { // If the element is found, return the index
            return index;
        }
        return indexOfHelper(o, current.next, index + 1); // Recursively call the method with the next node and incremented index
    }

    @Override
    public int lastIndexOf(Object o) {
        if (tail == null) { // If the list is empty, return -1
            return -1;
        }
        return lastIndexOfHelper(o, tail, size - 1); // Call the helper method to find the last index of the element
    }

    private int lastIndexOfHelper(Object o, Node current, int index) {
        if (current == null) { // If the end of the list is reached, return -1
            return -1;
        }
        if (current.elements.equals(o)) { // If the element is found, return the index
            return index;
        }
        return lastIndexOfHelper(o, current.previous, index - 1);
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }

        Node previous = head.next;
        while (previous != null) {
            Node curr = previous.next;
            while (curr != null) {
                if (((Comparable<T>) previous.elements).compareTo((T) curr.elements) > 0) {
                    T temp = (T) previous.elements;
                    previous.elements = curr.elements;
                    curr.elements = temp;
                }
                curr = curr.next;
            }
            previous = previous.next;
        }
    }

    @Override
        public void reverse() {
            if (head == null) {
                return;
            }
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                prev = current;
                current = next;
            }
            head = prev;
        }


    }





