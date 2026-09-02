import java.util.ArrayList;

class MyArray {
    private int ptr;
    private int[] arr;

    MyArray() {
        ptr = 0;
        arr = new int[10];
    }

    void insert(int val) {
        if (isFull())
            return;
        arr[ptr] = val;
        // System.out.println(val + " Element inserted at index " + ptr);
        ptr++;
    }

    void insertAtGivenIndex(int idx,int val){
         if(isFull()){
            System.out.println("Full Hai");
            return;
         }
         else if(idx < 0 || idx > ptr ) {
            System.out.println("Invalid Index");
            return;
         }
         else {
            for(int i = ptr ; i > idx ; i--){
                arr[i] = arr[i-1];
            }
            arr[idx] = val;
            ptr++;
         }

    }

    void insertAtFirst(int val){
        insertAtGivenIndex(0,val);
    }

    void insertAtLast(int val){
        insertAtGivenIndex(ptr,val);
    }

    int delete() {
        if(isEmpty()) {
            System.out.println("Array Empty hai");
            return -1;
        }
        ptr--;
        return arr[ptr];
    }

    int searchIndex(int val) {
        for (int i = 0; i < ptr; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }

    void updateIndex(int index , int newval){
        if(index >= ptr ) {
            System.out.println("Can't update");
            return;
        }
        arr[index] = newval;
    }

    
    void updateValue(int x, int val){

        int index = searchIndex(x);
        updateIndex(index,val);
    }

    boolean isEmpty() {
        return ptr == 0;
    }

    boolean isFull(){
        return ptr == arr.length;
    }

    void print() {
        for (int i = 0; i < ptr; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray stud = new MyArray();
        stud.insert(10);
        stud.insert(20);
        stud.insert(30);
        stud.insert(40);
        stud.insert(50);
        // stud.updateIndex(5,80);
        // stud.insertAtGivenIndex(6, 55);
        stud.insertAtFirst(11);
        stud.insertAtLast(111);
        // stud.updateValue(40,70);

        // System.out.println("Delete element is " + stud.delete());
        stud.print();

    }

}
