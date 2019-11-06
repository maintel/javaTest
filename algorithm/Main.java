package algorithm;

/**
 * main
 *
 * @author Maintel
 * @create 2018-08-14 22:41
 **/
public class Main {

    public static void main(String[] args) {
//        int[] a = {1, 3, -19, 8, -6, 5, -4, 6, 9, -6, -10, 50, -20, 3, 5};
        int[] a = {-1, -3, -19, -8, -6, 3, 1, -1, -9, 6, -10, -50, -20, -3, -5};

//        algorithmA(a);
        algorithmB(a);
    }

    private static void algorithmB(int[] a) {
        int min = 0;
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        int tempMin = 0;
        for (int i = 0; i < a.length; i++) {
            int tempSum = sum + a[i];
            if (sum <= 0 && a[i] >= 0) {
                tempMin = i;
                sum = a[i];
                maxSum = a[i];
            } else {
                sum = tempSum;
            }
            if (tempSum >= maxSum) {
                maxSum = tempSum;
                min = tempMin;
                end = i;
            }
        }

        if (end == 0) {
            min = tempMin;
            end = min;
        }

        System.out.println("end::" + end);
        System.out.println("min::" + min);
        System.out.println("max::" + maxSum);
    }


    private static void algorithmA(int[] a) {
        int sum = 0;

        for (int i :
                a) {
            sum = sum + i;
        }
        System.out.println(sum);

        int sumB = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int sumTemp = sumB + a[i];
            if (sumTemp >= max) {
                max = sumTemp;
                end = i;
            }
            sumB = sumTemp;
        }
        int sumC = 0;
        int min = 0;
        max = 0;
        for (int i = end; i >= 0; i--) {
            int sunTemp = sumC + a[i];
            if (sunTemp >= max) {
                max = sunTemp;
                min = i;
            }
            sumC = sunTemp;
        }

        System.out.println("end::" + end);
        System.out.println("min::" + min);
        System.out.println("max::" + max);
    }

}
