package yinyong;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("adadad");
        SoftReference<StringBuffer> softReference = new SoftReference<StringBuffer>(str);
        WeakReference<int[]> weakReference = new WeakReference<int[]>(new int[10000000]);
        SoftRefTest<StringBuffer> softRefTest = new SoftRefTest<StringBuffer>(str);
        str = null;
        System.out.println(str);
        System.gc();
        int[] strongReference = new int[100000000];
        int[] strongReference2 = new int[100000000];
        int[] strongReference3 = new int[100000000];
        System.out.println(softReference.get().hashCode());
        System.out.println(weakReference.get().hashCode());
        System.out.println(softRefTest.get().hashCode());
    }

}
