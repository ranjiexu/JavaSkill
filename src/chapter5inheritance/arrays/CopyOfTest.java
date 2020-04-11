package chapter5inheritance.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 利用反射实现copyOf
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"a", "b", "c", "d", "e"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("will generate an exception");
        b = (String[]) badCopyOf(b, 10);
    }

    /**
     * 错误的copyOf
     * @param o
     * @param newLength
     * @return
     */
    public static Object[] badCopyOf(Object[] o, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(o, 0, newArray, 0, Math.min(o.length, newLength));
        return newArray;
    }

    /**
     * 正确的copyOf
     * @param o
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object o, int newLength) {
        Class cl = o.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(o);
        Object newArray = Array.newInstance(componentType, length);
        System.arraycopy(o, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
