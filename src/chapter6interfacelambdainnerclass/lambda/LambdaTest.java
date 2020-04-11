package chapter6interfacelambdainnerclass.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * lambda 表达式的使用
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter",
                            "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(10000, event -> System.out.println("The time is " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
