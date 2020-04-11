package chapter8generic.pair2;

import chapter8generic.Pair;

import java.time.LocalDate;

/**
 * 类型变量的限定
 *
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] l = new LocalDate[3];
        l[0] = LocalDate.of(1990, 12, 9);
        l[1] = LocalDate.of(1990, 3, 14);
        l[2] = LocalDate.of(1989, 2, 1);
        Pair<LocalDate> pair = ArrayAlg.minmax(l);
        System.out.println("min:" + pair.getFirst());
        System.out.println("max:" + pair.getSecond());
    }
}

class ArrayAlg {
    public static <T extends Comparable<? super T>> Pair<T> minmax(T[] a) {
        if (a == null || a.length <= 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
