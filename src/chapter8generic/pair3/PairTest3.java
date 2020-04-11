package chapter8generic.pair3;

import chapter5inheritance.equals.Employee;
import chapter5inheritance.equals.Manager;
import chapter8generic.Pair;

/**
 * PECS原则：Producer Extends，Consumer Super
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager bob = new Manager("bob", 5000, 1990, 12,9);
        Manager jack = new Manager("jack", 8000, 1996, 3, 25);
        Pair<Manager> pair = new Pair<>(bob, jack);
        printBuddies(pair);

        bob.setBonus(5000);
        jack.setBonus(500);
        Manager[] managers = {bob, jack};
        Pair<Manager> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("min.name:" + result.getFirst().getName() + " and max.name:" + result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("min.name:" + result.getFirst().getName() + " and max.name:" + result.getSecond().getName());
    }

    /**
     * 子类型限定，适合读 PECS 原则中的PE
     * @param p
     */
    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println("first.name:" + first.getName() + " and second.name:" + second.getName());
    }

    /**
     * 超类型限定，适合写 PECS 原则中的CS
     * @param m
     * @param result
     */
    public static void minmaxBonus(Manager[] m, Pair<? super Manager> result) {
        if (m == null || m.length <= 0) {
            return;
        }
        Manager min = m[0];
        Manager max = m[0];
        for (int i = 1; i < m.length; i++) {
            if (min.getBonus() > m[i].getBonus()) {
                min = m[i];
            }
            if (max.getBonus() < m[i].getBonus()) {
                max = m[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] m, Pair<? super Manager> result) {
        minmaxBonus(m, result);
        PairAlg.swap(result);
    }
}

class PairAlg {
    /**
     * 无限定通配符可以set null；可以get null object
     * @param pair
     * @return
     */
    public boolean hasNull(Pair<?> pair) {
        return (pair.getFirst() == null || pair.getSecond() == null);
    }

    /**
     * 通配符捕获
     * @param pair
     */
    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        T temp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(temp);
    }

}
