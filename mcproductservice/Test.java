public class Test {

    //258

    int val=153;
    //1+125+27=153
    int result=0;

    while(val >0){
       int  tempval=val % 10; ///
        result= tempval*tempval*tempval;
        result+=result;
        val=val / 10;
    }

    if( result== val){
        System.out.println(" Its an Amstrong value");
    }

    else{
        System.out.println(" not an amstrong value");
    }

}
