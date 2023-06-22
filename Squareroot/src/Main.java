public class Main {
    public static void main(String[] args) {
        System.out.println(solve(25));


    }
    public static int solve(int A) {
        int ans=0;
        for (int i=1;i*i<=A;i++){
            if(i*i==A)
                return i;
        }
        return -1;
    }
}