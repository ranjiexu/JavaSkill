package chapter3base.bigInteger;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 中奖概率，用大数据来计算
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how much number you need to draw:");
        int n = scanner.nextInt();
        System.out.println("highest number you need to draw:");
        int h = scanner.nextInt();

        BigInteger odd = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++){
            // odd = odd*(h - i + 1)/i;
            odd = odd.multiply(BigInteger.valueOf(h - i + 1)).divide(BigInteger.valueOf(i));
        }


        System.out.println(odd + "");
    }
}
