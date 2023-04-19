public class MyLinkedList<T> implements MyList<T> {
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

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

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
    }
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
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
        return (T) current.elements;
    }
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return (T) current.elements;
    }

    @Override
    public int indexOf(Object o) {
        if (head == null) {
            return -1;
        }
        return indexOfHelper(o, head, 0);
    }

    private int indexOfHelper(Object o, Node current, int index) {
        if (current == null) {
            return -1;
        }
        if (current.elements.equals(o)) {
            return index;
        }
        return indexOfHelper(o, current.next, index + 1);
    }

    @Override
    public int lastIndexOf(Object o) {
        if (tail == null) {
            return -1;
        }
        return lastIndexOfHelper(o, tail, size - 1);
    }

    private int lastIndexOfHelper(Object o, Node current, int index) {
        if (current == null) {
            return -1;
        }
        if (current.elements.equals(o)) {
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
}
