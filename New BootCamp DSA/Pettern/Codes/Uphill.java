public class Uphill {
    public static void main(String[]arg){
        int n=5;
        for(int i=1;i<=n;i++){
            
            for(int j = i ; j <= n-1 ; j++){
                System.out.print("  ");
            }
            for(int k = 1 ; k <= i ; k++){
                System.out.print("* ");
            }
            for(int l = 2 ; l <= i ; l++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
