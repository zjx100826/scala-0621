import org.omg.CORBA.PUBLIC_MEMBER;

public class AA {

    public static void main(String[] args) {
        m1(1,2,3,4);
        m1(new int[]{1,2,3,4,5,6});
    }

    //用于区别scala可变函数不可以传数组
    public static void m1(int... arr ){
        for(int a :arr){
            System.out.println(a );
        }
    }
}
