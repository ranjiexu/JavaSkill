package chapter3base.lotteryDrawing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 抽奖，数组实现
 */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many numbers you need draw:");
        int k = scanner.nextInt();
        System.out.println("highest number you need draw:");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        int[] result = new int[k];

        for (int i = 0; i < result.length; i++) {
            int index = (int) (Math.random() * n);
            result[i] = numbers[index];
            numbers[index] = numbers[n - 1];
            n--;
        }

        Arrays.sort(result);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
