package chapter3base.lotteryArray;

/**
 * 三角数组
 */
public class LotteryArray {
    private final static int MAX = 10;
    public static void main(String[] args) {
        int[][] goal = new int[MAX + 1][];
        for (int i = 0; i <= MAX; i++) {
            goal[i] = new int[i + 1];
        }

        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < goal[i].length; j++) {
                int lotteryOdds = 1;
                for (int k = 1; k <= j; k++) {
                    lotteryOdds = lotteryOdds * (i - k + 1)/ k;
                }
                goal[i][j] = lotteryOdds;
            }
        }

        for (int[] row : goal) {
            for (int i : row) {
                System.out.printf("%4d", i);
            }
            System.out.println();
        }
    }
}
