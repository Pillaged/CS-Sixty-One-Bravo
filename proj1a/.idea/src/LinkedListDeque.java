public class LinkedListDeque<T>{
    public static class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(T i, IntNode n, IntNode p){
            next = n;
            item = i;
            prev = p;
        }
    }
    /* Assign the variables. */
    public IntNode sentinel;
    private T hiddenval = (T)null;
    public int size;

    /* Initialize empty linked list. */
    public LinkedListDeque(){
        sentinel = new IntNode(hiddenval, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    /* Initialize linked list with a starter value. */
    public LinkedListDeque(T i){
        sentinel = new IntNode(hiddenval, null, null);
        IntNode first = new IntNode(i, sentinel, sentinel);
        sentinel.next = first;
        sentinel.prev = first;
        size = 1;
    }

    /* Insert a node after the sentinel, before the first value. Increment
        size by one. */
    public void addFirst(T x){
        IntNode piece = new IntNode(x, sentinel.next, sentinel);
        sentinel.next.prev = piece;
        sentinel.next = piece;
        size += 1;
    }
    /* Insert a node after the last value, before the sentinel, increment size by one. */
    public void addLast(T x){
        IntNode piece = new IntNode(x, sentinel, sentinel.prev);
        this.sentinel.prev.next = piece;
        this.sentinel.prev = piece;
        size += 1;
    }
    /* Evaluates if DLL is empty, meaning one sentinel node not connected to anything. */
    public boolean isEmpty() {
        if (this.sentinel.next == null && this.sentinel.prev == null) {
            return true;
        }
        return false;
    }
    /* Returns int var size */
    public int size(){
        return this.size;
    }
    /* Print out every item in the list */
    public void printDeque(){
        IntNode pointer = this.sentinel.next;
        while(pointer != sentinel){
            System.out.print(pointer.item+" ");
            pointer = pointer.next;
        }
    }
    /* Remove first item from list and return it. */
    public T removeFirst(){
        IntNode pointer = this.sentinel;
        try{
            return pointer.next.item;
        }
        catch(Exception e){
            return null;
        }
    }
    public T RemoveLast(){
        IntNode pointer = this.sentinel;
        try{
            return pointer.prev.item;
        }
        catch(Exception e){
            return null;
        }
    }
    public T get(int index){
        int i = index;
        IntNode p = sentinel.next;
        while(i >= 0){
            p = p.next;
            i--;
        }
        return p.item;
    }
    /* Creates deep copy of other list using iteration. */
    public LinkedListDeque(LinkedListDeque other){
        this.sentinel = new IntNode(hiddenval, null, null);
        IntNode p = other.sentinel;
        while (p != this.sentinel){
            this.addFirst((T) p.next.item);
            p = p.next;
        }

    }
}
