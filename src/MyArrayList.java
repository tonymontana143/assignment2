import java.util.Arrays;
public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size;
    public MyArrayList(){
        elements=new Object[10];
        size=0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean contains(Object o){
        return indexOf(o)!=-1;
    }
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }}
    @Override
    public void add(T item){
        ensureCapacity(size+1);
        elements[size++]=item;
    }
    @Override
    public void add(T item, int index){
        if(index<0||index>size){
            return;
        }
        ensureCapacity(size+1);
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=item;
        size++;
        }
    @Override
    public boolean remove(T item){
        int index=indexOf(item);
        if(index==-1){
            return false;
        }
        remove(index);
        return true;
    }
    @Override
    public T remove(int index){
        if(index<0||index>=size){
            return;
        }
        T item=(T) elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index-1);
        elements[--size]=null;
        return item;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }
    @Override
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
}
