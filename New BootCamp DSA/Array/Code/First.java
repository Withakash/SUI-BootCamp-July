import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Size Batao ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Elements Add karo ");

        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : arr){
           System.out.print(x + " ");
        }
    }
}
