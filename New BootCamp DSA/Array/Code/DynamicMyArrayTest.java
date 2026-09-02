// import java.util.ArrayList;

class MyArray {
    private int ptr;
    private int[] arr;

    MyArray() {
        ptr = 0;
        arr = new int[10];
    }

    void upgrade(){
        int newSize = arr.length + (arr.length / 2);
        int[] newArr = new int[newSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.out.println("Hamne Naya Array Banaya");
    }

    void insert(int val) {
        if (isFull()){
           upgrade();
        }
        arr[ptr] = val;
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

    int deleteAtGivenIndex(int idx){
        if(isEmpty()){
            System.out.println("Array Empty hai");
            return -1;
        }
        if(idx < 0 || idx > ptr){
            System.out.println("Invalid Index");
            return -1;
        }
        int bcup = arr[idx];
        
        for(int i = idx ; i < ptr - 1; i++){
            arr[i] = arr[i+1];
        }
        ptr--;
        return bcup;
    }

    int deleteGivenElement(int ele){
        int idx = searchIndex(ele);
        return deleteAtGivenIndex(idx);
    }

    int deleteAtFirst(){
        // int bcup = arr[0];
        // for(int i = 0 ; i < ptr -1 ; i++){
        //     arr[i] = arr[i+1];
        // }
        // ptr--;
        // return bcup;

        return deleteAtGivenIndex(0);
    }

    int deleteAtLast(){
        return delete();
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

public class DynamicMyArrayTest {
    public static void main(String[] args) {
        MyArray stud = new MyArray();
        stud.insert(10);
        stud.insert(20);
        stud.insert(30);
        stud.insert(40);
        stud.insert(50);
        stud.insert(60);
        stud.insert(70);
        stud.insert(80);
        stud.insert(90);
        stud.insert(100);
        stud.insert(101);
        stud.insert(102);
        stud.insert(103);
        stud.insert(104);
        stud.insert(105);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);
        stud.insert(106);

        
        stud.print();

    }

}
