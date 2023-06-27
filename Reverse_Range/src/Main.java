import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer>al =new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(4);
        al.add(3);
        al.add(1);

        System.out.println(solve(al,1,4));
    }

        public static ArrayList<Integer> solve (ArrayList<Integer> A, int B, int C) {

            int n=A.size();
            while(B<C){
                int temp=A.get(B);
                A.set(B,A.get(C));
                A.set(C,temp);
                B++;
                C--;
            }
            return A;
        }


}