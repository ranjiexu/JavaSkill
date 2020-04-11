package chapter5inheritance.equals;

public class Manager extends Employee {
    private double bonus;


    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }

        Manager obj = (Manager) otherObject;

        return this.bonus == obj.bonus;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return result + 17 * new Double(bonus).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus: " + bonus + "]";
    }
}
