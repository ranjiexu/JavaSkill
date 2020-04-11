package chapter8generic.pair1;

import chapter8generic.Pair;

/**
 * 范型类实利
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] a = {"Woooo", "W", "oooo"};
        Pair<String> pair = ArrayAlg.minmax(a);
        System.out.println("min:" + pair.getFirst() + ", max:" + pair.getSecond());
    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] strings) {
        if (strings == null || strings.length <= 0) {
            return null;
        }
        String min = strings[0];
        String max = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (min.compareTo(strings[i]) > 0) {
                min = strings[i];
            }
            if (max.compareTo(strings[i]) < 0) {
                max = strings[i];
            }
        }
        return new Pair<>(min, max);
    }
}

