import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;  // the array to store the elements
    private int size;           // the number of elements currently stored in the array

    public MyArrayList() {
        elements = new Object[10];  // initialize the array with a default capacity of 10
        size = 0;                   // initially there are no elements in the array
    }
    public void reverse(){
        for(int i=0;i< (size()/2);i++){
            Object temp=elements[i];
            elements[i]=elements[size()-i-1];
            elements[size()-i-1]=temp;

        }
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;    // check if the element is in the array
    }

    private void ensureCapacity(int minCapacity) {
        // increase the capacity of the array if needed
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;     // double the capacity
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;              // make sure the new capacity is at least as large as the minimum capacity needed
            }
            elements = Arrays.copyOf(elements, newCapacity);  // copy the elements to a new array with the new capacity
        }
    }

    @Override
    public boolean add(T item) {
        ensureCapacity(size + 1);   // increase the capacity if necessary
        elements[size++] = item;    // add the element to the end of the array
        return true;
    }


    @Override
    public void adAll(Collection<? extends> collection){
        int collectionSize=collection.size();
        int minLength=size+collectionSize;
        if(minLength> elements.length){
            int newCapacity= elements.length*2;
            if(newCapacity<minLength){
                newCapacity=minLength;
            }
            elements=Arrays.copyOf(elements,newCapacity);
        }
        for(Object item:collection){
            elements[size++]=item;
        }
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            return;                 // do nothing if the index is out of bounds
        }
        ensureCapacity(size + 1);   // increase the capacity if necessary
        System.arraycopy(elements, index, elements, index + 1, size - index);  // shift the elements after the index to the right
        elements[index] = item;     // add the element to the specified index
        size++;                     // increase the size of the array
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);  // find the index of the element
        if (index == -1) {
            return false;           // return false if the element is not in the array
        }
        remove(index);              // remove the element at the specified index
        return true;                // return true to indicate that an element was removed
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();  // throw an exception if the index is out of bounds
        }
        T item = (T) elements[index];               // save the element to be removed
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);  // shift the elements after the index to the left
        elements[--size] = null;                    // remove the last element and decrement the size
        return item;                                // return the removed element
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();  // throw an exception if the index is out of bounds
        }
        return (T) elements[index];                 // return the element at the specified index
    } @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void sort() {
        Arrays.sort(elements, 0, size);
    }
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}



