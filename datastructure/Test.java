package datastructure;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        LinkedList a = new LinkedList();


        TreeMap<String,String>  treeMap = new TreeMap<>();

        treeMap.put("a","a");
        treeMap.put("b","b");
        treeMap.put("c","c");
        treeMap.put("a","c");

        HashMap<Integer, String> map = new HashMap<>();
        Integer a100 = new Integer(127);
        Integer a2 = new Integer(31);
        Integer a3 = new Integer(63);
        Integer a4 = new Integer(15);
        Integer a5 = new Integer(15);
        Integer a6 = new Integer(255);
        Integer a7 = new Integer(511);
        Integer a8 = new Integer(1023);
        Integer a9 = new Integer(2047);
        Integer a10 = new Integer(4095);
        Integer a11 = new Integer(8191);
        Integer a12 = new Integer(16383);
        Integer a13 = new Integer(32767);
        Integer a14 = new Integer(65535);
        Integer a15 = new Integer(131071);
        Integer a16 = new Integer(262143);
        map.put(a100, "aaa");
        map.put(a2, "bbb");
        map.put(a3, "ccc");
        map.put(a4, "ddd");
        map.put(a5, "eee");
        map.put(a6, "fff");
        map.put(a7, "ggg");
        map.put(a8, "hhh");
        map.put(a9, "iii");
        map.put(a10, "jjj");
        map.put(a11, "kkk");
        map.put(a12, "lll");
        map.put(a13, "lll");
        map.put(a14, "lll");
        map.put(a15, "lll");
        map.put(a16, "lll");
        int hash1 = hash(a100);
        System.out.println(16 & hash1);
        System.out.println(32 & hash1);
        System.out.println(64 & hash1);
        System.out.println(64 & hash1);
        int hash2 = hash(a2);
        System.out.println("=======");

        System.out.println(16 & hash2);
        System.out.println(32 & hash2);
        System.out.println(64 & hash2);
        System.out.println("=======");

        int hash3 = hash(a3);
        System.out.println(31 & hash3);
        int hash4 = hash(a4);
        System.out.println(31 & hash4);

        System.out.println("=======");

        System.out.println((31 & hash(a5))  + ":::::" + (63 & hash(a5)));
        System.out.println((31 & hash(a6))  + ":::::" + (63 & hash(a6)));
        System.out.println((31 & hash(a7))  + ":::::" + (63 & hash(a7)));
        System.out.println((31 & hash(a8))  + ":::::" + (63 & hash(a8)));
        System.out.println((31 & hash(a9))  + ":::::" + (63 & hash(a9)));
        System.out.println((31 & hash(a10))  + ":::::" + (63 & hash(a10)));
        System.out.println((31 & hash(a11))  + ":::::" + (63 & hash(a11)));
        System.out.println((31 & hash(a12))  + ":::::" + (63 & hash(a12)));
        System.out.println((31 & hash(a13))  + ":::::" + (63 & hash(a13)));
        System.out.println((31 & hash(a14))  + ":::::" + (63 & hash(a14)));
        System.out.println((31 & hash(a15))  + ":::::" + (63 & hash(a15)));
        System.out.println((31 & hash(a16))  + ":::::" + (63 & hash(a16)));



        for (Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey() + "::::" + entry.getValue());
        }


        System.out.println("==========");
        int newCap, newThr = 0;
        System.out.println((newCap = 16 << 1));
        System.out.println(newCap);



    }


    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
