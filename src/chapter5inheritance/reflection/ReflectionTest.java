package chapter5inheritance.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射相关测试
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a class:");
        String className = scanner.next();

        try {
            Class cl = Class.forName(className);
            if (cl == null) {
                return;
            }
            // 打印类名和超类
            String modifier = Modifier.toString(cl.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print("class " + cl.getName());
            Class scl = cl.getSuperclass();
            if (scl != null) {
                System.out.print(" extends " + scl.getName());
            }
            System.out.println();
            System.out.println("{");
            // 打印所有的构造方法
            printConstructors(cl);
            // 打印所有的成员方法
            printMethods(cl);
            // 打印所有的域
            printFields(cl);
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印所有的构造器方法
     * @param cl
     */
    public static void printConstructors(Class cl) {
        if (cl == null) {
            return;
        }
        System.out.println();

        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String modifier = Modifier.toString(c.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(" " + modifier);
            }
            System.out.print(" " + c.getName() + "(");
            Class[] types = c.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(types[i].getName());
            }
            System.out.print(");");
            System.out.println();
        }
    }

    /**
     * 打印所有的成员方法
     * @param cl
     */
    public static void printMethods(Class cl) {
        if (cl == null) {
            return;
        }
        System.out.println();

        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            String modifier = Modifier.toString(m.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(" " + modifier);
            }
            System.out.print(" " + m.getReturnType().getName() + " " + m.getName() + "(");
            Class[] types = m.getParameterTypes();
            for (int i = 0; i < types.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(types[i].getName());
            }
            System.out.print(");");
            System.out.println();
        }
    }

    /**
     * 打印所有的域
     * @param cl
     */
    public static void printFields(Class cl) {
        if (cl == null) {
            return;
        }
        System.out.println();

        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            String modifier = Modifier.toString(f.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(" " + modifier);
            }
            System.out.print(" " + f.getType().getName() + " " + f.getName());
            System.out.println();
        }
    }
}
