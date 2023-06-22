public class Main {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }


    public static int solve(int A) {
        int fact=0;
        if(A==1)
            return 0;
        for(int i=1;i<A;i++){
            if(A%i==0){
                fact+=i;
            }

        }
        if(fact==A)
            return 1;
        else
            return 0;
    }
}