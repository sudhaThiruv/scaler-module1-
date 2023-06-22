public class Main {
    public static void main(String[] args) {
        System.out.println(solve(19));
    }

    public static int solve(int A) {
        int prime=0;
        for(int i=0;i<=A;i++){
            if(countfactor(i)==2)
                prime++;
        }
        return prime;
    }

    public static int countfactor(int n){
        int fact=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(i==n/i){
                    fact++;
                }
                else{
                    fact=fact+2;
                }
            }

        }
        return fact;
    }
}