// import java.util.ArrayList;

class MyArray<T> {

    public static final int INIT_CAPACITY = 10;
    private int ptr;
    private Object[] arr;

    MyArray() {
        ptr = 0;
        arr = new Object[INIT_CAPACITY];
    }

    int size() {
        return ptr;
    }

    int capacity() {
        return arr.length;
    }

    void upgrade() {
        int newSize = arr.length + (arr.length / 2);
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        // System.out.println("Hamne Naya Array Banaya");
    }

    void shrink() {
        if (capacity() <= INIT_CAPACITY)
            return;

        if (capacity() / 2 >= size()) {
            int newSize = Math.max(INIT_CAPACITY,capacity()/2);
            Object[] newArr = new Object[newSize];

            
            for (int i = 0; i < newSize; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            // System.out.println("Array Shrink ho gya");
        }

        
    }

    void insert(T val) {
        if (isFull()) {
            upgrade();
        }
        arr[ptr] = val;
        ptr++;
    }

    void insertAtGivenIndex(int idx, T val) {
        if (isFull()) {
            System.out.println("Full Hai");
            return;
        } else if (idx < 0 || idx > ptr) {
            System.out.println("Invalid Index");
            return;
        } else {
            for (int i = ptr; i > idx; i--) {
                arr[i] = arr[i - 1];
            }
            arr[idx] = val;
            ptr++;
        }

    }

    void insertAtFirst(T val) {
        insertAtGivenIndex(0, val);
    }

    void insertAtLast(T val) {
        insertAtGivenIndex(ptr, val);
    }

    T delete() {

        if (isEmpty()) {
            System.out.println("Array Empty hai");
            return null;
        }

        ptr--;

        @SuppressWarnings("unchecked")
        T deletedValue = (T) arr[ptr];

        shrink();

        return deletedValue;
    }

    T deleteAtGivenIndex(int idx) {
        if (isEmpty()) {
            System.out.println("Array Empty hai");
            return null;
        }
        if (idx < 0 || idx >= ptr) {
            System.out.println("Invalid Index");
            return null;
        }
        @SuppressWarnings("unchecked")
        T bcup = (T) arr[idx];

        for (int i = idx; i < ptr - 1; i++) {
            arr[i] = arr[i + 1];
        }
        ptr--;
        shrink();
        return bcup;
    }

    T deleteGivenElement(T ele) {
        int idx = searchIndex(ele);
        return deleteAtGivenIndex(idx);
    }

    T deleteAtFirst() {
        // int bcup = arr[0];
        // for(int i = 0 ; i < ptr -1 ; i++){
        // arr[i] = arr[i+1];
        // }
        // ptr--;
        // return bcup;

        return deleteAtGivenIndex(0);
    }

    T deleteAtLast() {
        return delete();
    }

    @SuppressWarnings("unchecked")
    T get(int index){
        return (T)arr[index];
    }

    int searchIndex(T val) {
        for (int i = 0; i < ptr; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }

    void updateIndex(int index, int newval) {
        if (index >= ptr) {
            System.out.println("Can't update");
            return;
        }
        arr[index] = newval;
    }

    void updateValue(T x, int val) {

        int index = searchIndex(x);
        updateIndex(index, val);
    }

    boolean isEmpty() {
        return ptr == 0;
    }

    boolean isFull() {
        return ptr == arr.length;
    }

    void print() {
        for (int i = 0; i < ptr; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

public class FullMyArray {
    public static void main(String[] args) {
        // MyArray stud = new MyArray();

        // for (int i = 1; i < 10; i++)
        //     stud.insert(i * 10);

    

        // stud.print();
        // System.out.println();

        // System.out.println("Capacity is " + stud.capacity() + " Size is " + stud.size());

        // System.out.println(stud.get(8));

        MyArray<Object> stud = new MyArray<Object>();
        stud.insert("Akash");
        stud.insert("Satyam");
        stud.insert(10);
        stud.insert(10.5);
        stud.insert(true);

        stud.print();

    }

}
