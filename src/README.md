**********MyArrayList Implementation**********

The **MyArrayList** class is an implementation of the MyList interface, which represents a dynamic list that can store elements of any type. This implementation uses an array to store the elements and dynamically resizes the array as needed to accommodate more elements.

**Constructor**

`MyArrayList()` - Constructs an empty list with an initial capacity of 10.

******************Methods******************

`int size()` - Returns the number of elements in the list.

`boolean contains(Object o)` - Returns true if the list contains the specified element, false otherwise.

`boolean add(T item)` - Appends the specified element to the end of the list.

`void add(T item, int index)` - Inserts the specified element at the specified position in the list.

`boolean remove(T item)` - Removes the first occurrence of the specified element from the list.

`T remove(int index)` - Removes the element at the specified position in the list.

`T get(int index)` - Returns the element at the specified position in the list.

`int indexOf(Object o)` - Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

`int lastIndexOf(Object o)` - Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

`void sort() `- Sorts the elements in the list in ascending order.

`void clear()` - Removes all of the elements from the list.
**Private Methods**

`void ensureCapacity(int minCapacity)` - Increases the capacity of the array, if necessary, to ensure that it can hold at least the number of elements specified by the argument minCapacity





**Documentation for MyLinkedList<T>:**

This is a generic class that implements the MyList<T> interface. It represents a doubly linked list that can store elements of any type T. The class provides methods for adding, removing, and accessing elements in the list, as well as sorting the list.

**Constructor:**

`public MyLinkedList()`: Constructs an empty MyLinkedList object.

**Methods:**


`public int size()`: Returns the number of elements in the list.

`public boolean contains(Object o)`: Returns true if the list contains the specified element, false otherwise.

`public boolean add(T item)`: Adds the specified element to the end of the list and returns true.

`public void add(T element, int index)`: Inserts the specified element at the specified position in the list.

`public boolean remove(Object o)`: Removes the first occurrence of the specified element from the list and returns true if the element was found, false otherwise.

`public T remove(int index)`: Removes the element at the specified position in the list and returns it.

`public void clear()`: Removes all elements from the list.

`public T get(int index)`: Returns the element at the specified position in the list.

`public int indexOf(Object o)`: Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.

`public int lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element in the list, or -1 if the element is not found.

`public void sort()`: Sorts the elements in the list in ascending order, using the natural ordering of the elements.