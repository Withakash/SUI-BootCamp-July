public class ArmStrongTest {

    static int power(int digit , int p){
        int res = 1;
        while(p-- > 0){
            res *= digit;
        }
        return res;
    }
    public static void main(String[] str){
        int n = 153;
        int temp = n;
        int c = 0;
        while(n != 0){
            c++;
            n = n/10;
        }
        int arm = 0;

        n = temp;
        while(n != 0 ){
            int lastD = n % 10;
            //  arm = arm + (int)Math.pow(lastD, c);
             arm = arm + power(lastD, c);

             n/=10;
        }

        if(arm == temp) System.out.println("Armstrong");
        else System.out.println("Not ArmStrong");
    }
}
