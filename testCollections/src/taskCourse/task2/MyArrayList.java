package taskCourse.task2;

public class MyArrayList<T> {
    private final int INIT_SIZE = 10;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;


    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
    public void remove(T element){}

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }


    public T get(int index) {
        return (T) array[index];
    }

}
