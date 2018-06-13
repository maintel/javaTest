package zhujie;



import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        TestZJ testZJ = new TestZJ();
        //想要拿到注解 就要用到反射
        Class clazz = testZJ.getClass();
        // 拿到参数上的注解
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(testZJ.aInt);
        System.out.println(testZJ.bInt);
        for (Field f :
                fields) {
            IntegerValue integerValue = f.getAnnotation(IntegerValue.class);
            if (integerValue != null) {
                System.out.println(integerValue.value());
                try {
                    f.setInt(testZJ,integerValue.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(integerValue.name());
            }
        }
        System.out.println(testZJ.aInt);
        System.out.println(testZJ.bInt);
    }
}
