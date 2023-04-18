import java.util.Arrays;
public class MyArrayList implements MyList<T>{
    private Object[] elements;
    private int size;
    public MyArrayList(){
        elements=new Object[10];
        size=0;
    }
    @Override
    public int getSize(){
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
        }
    @Override
    public void add(T item){
        ensureCapacity(size+1);
        elements[size++]=item;
    }

}
