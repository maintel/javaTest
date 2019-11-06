import java.util.HashMap;
import java.util.Map;

/**
 * byteTest
 *
 * @author Maintel
 * @create 2019-05-25 19:04
 **/
public class ByteTest {

    public static void main(String[] args) {
//        String str="我是中国人";
//        byte[] arr=str.getBytes();
//        System.out.println("打印："+arr);
//        System.arraycopy(a, 0, b, 0, n);
//
//        System.out.println(new String(arr).toString());


        int[] nums = new int[]{2, 4, 4,4};
        int target = 8;
        int[] orderNum = new int[target];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println( map.get(complement)+"  " +  i);
            }
            map.put(nums[i], i);
        }
    }

}
