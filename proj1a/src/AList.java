public class AList<T> {
    private T[] items;
    private int size;
    private int startlocation;
    T blank;
    /** Creates an empty list. */
    public AList() {
        items = (T[]) new Object[8];
        size = 0;
        startlocation = 0;
    }

    /** Inserts X into the front of the list. */
    public void addFirst(T item) {
        if (startlocation < 0) {
            startlocation = items.length+startlocation;
        }
        items[startlocation] = item;
        size++;
        startlocation--;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }
    public boolean isEmpty() {
        if (size > 0) {
            return true;
        }
        return false;
    }
    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T last = items[size];
        size--;
        return last;
    }

}
