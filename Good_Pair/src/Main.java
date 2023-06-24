import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>al =new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(4);
        al.add(3);
        al.add(1);

        System.out.println(solve(al,5));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int count=0;
        int n=A.size();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(A.get(i)+A.get(j)==B)
                    count++;
            }
        }
        return count;
    }
}