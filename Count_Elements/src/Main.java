import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A=new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(3);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {

        int count=0;
        int max=A.get(0);
        int n=A.size();

        for(int i=0;i<n;i++){
            if(A.get(i)>max){
                max=A.get(i);
                count=1;
            }
            else if(A.get(i)==max){
                count++;
            }
        }

        return n-count;
    }
}