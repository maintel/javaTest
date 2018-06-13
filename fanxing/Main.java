package fanxing;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass());
        System.out.println(arrayList2.getClass());
        System.out.println(arrayList1.getClass()==arrayList2.getClass());


        A a = new B();
//        a.setValue(1);
        a.setAnInt(10);

        System.out.println(a.getAnInt());
        System.out.println(a.getValue());

    }

}
