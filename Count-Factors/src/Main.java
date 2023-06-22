public class Main {
    public static void main(String[] args) {
        System.out.println(solve(10));
        //solve(10);

    }
    public static  int solve(int A) {
        int fact=0;

        for(int i=1;i*i<=A;i++){
            if(A%i==0){
                if(i==A/i){
                    ++fact;
                }
                else

                    fact=fact+2;
            }
        }
        return fact;

    }
}