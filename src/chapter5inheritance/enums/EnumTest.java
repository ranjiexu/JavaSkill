package chapter5inheritance.enums;

import java.util.Scanner;

/**
 * 枚举类的测试
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Size.valueOf(input);
        System.out.println("size:" + size);
        System.out.println("size abbreviation:" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job, you are fat");
        }
    }

    enum Size {
        // 枚举类的实利
        SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");


        Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        private String abbreviation;

        public String getAbbreviation() {
            return abbreviation;
        }
    }
}
