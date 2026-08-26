public class SearchMonika {
    public static void main(String[] args){
        String[] studs = {"Sha","Paw","Pra","Moni","Sat","Shiv","Grv"};

        for(int i = 0 ; i < studs.length; i++){
            if(studs[i] == "Moni") {
                System.out.print("Monika ka index hai  " + i);
                return;
            }
        }
    }
}
