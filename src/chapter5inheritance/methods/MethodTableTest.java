package chapter5inheritance.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * invoke 调试
 */
public class MethodTableTest {
    public static void main(String[] args) {
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);

            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f) {
        System.out.println(f);
        double dx = (to -from) / (n - 1);
        for (double x = from; x <= to; x = x + dx) {
            try {
                double y = (double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f", x, y);
                System.out.println();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
