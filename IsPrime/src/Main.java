public class Main {
    public static void main(String[] args) {

        System.out.println(solve(9));
        System.out.println();
    }
    public static int solve(long A) {
        if(countFactor(A)==2)
            return 1;
        else
            return 0;
    }

    public static int countFactor(long A){
        int fact=0;
        for(long i=1;i*i<=A;i++){
            if(A%i==0){
                if(i==A/i){
                    fact++;
                }
                else
                    fact=fact+2;
            }
        }
        return fact;
    }
}