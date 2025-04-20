public class Test {

    //258


    public static void main (String args[]) {


        int val=153;
        int value=val;
        //1+125+27=153
        int result=0;

        while (val > 0){

            int  tempval=val % 10; ///
            result+= tempval*tempval*tempval;
            //result=result;
            val=val / 10;
        }

        if( result== value){
            System.out.println(" Its an Amstrong value");
        }

        else{
            System.out.println(" not an amstrong value");
        }
    }
}
