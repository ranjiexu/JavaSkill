package chapter5inheritance.equals;

/**
 * Object 复写 equals hashCode toString
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice", 7500, 1990, 4, 8);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice", 7500, 1990, 4, 8);
        Employee bob = new Employee("Bob", 8000, 1988, 1,5);
        System.out.println("alic1 == alice2: " + (alice1 == alice2));
        System.out.println("alic1 == alice3: " + (alice1 == alice3));
        System.out.println("alic1 == bob: " + (alice1 == bob));
        System.out.println("alic1 equals alice2: " + (alice1.equals(alice2)));
        System.out.println("alic1 equals alice3: " + (alice1.equals(alice3)));
        System.out.println("alic1 equals bob: " + (alice1.equals(bob)));

        Manager carl = new Manager("Carl", 9000, 1979, 4,4);
        Manager boss = new Manager("Carl", 9000, 1979, 4,4);
        boss.setBonus(5000);
        System.out.println("boss.toString:" + boss.toString());
        System.out.println("carl equals boss:" + carl.equals(boss));
        System.out.println("alic1 hashCode:" + alice1.hashCode());
        System.out.println("alic3 hashCode:" + alice3.hashCode());
        System.out.println("carl hashCoe:" + carl.hashCode());
        System.out.println("boss hashCode:" + boss.hashCode());
    }
}
