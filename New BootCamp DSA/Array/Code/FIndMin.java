import java.util.Scanner;

public class FIndMin {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Size Batao ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Elements Add karo ");

        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }


        int min = arr[0];

        for(int i = 1 ; i < n ; i++){
            if(arr[i] < min) min = arr[i];
        }

        System.out.println("Minimum is " + min);
    }
}
