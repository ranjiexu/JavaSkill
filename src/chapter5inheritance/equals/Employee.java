package chapter5inheritance.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public boolean equals(Object otherObject) {

        // 检测this和 otherObject 是否引用同一个对象
        if (this == otherObject) {
            return true;
        }

        // 判断 otherObject 是否为null
        if (otherObject == null) {
            return false;
        }

        // getClass 是否相同
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        // 强转为当前对象
        Employee obj = (Employee) otherObject;

        // 对域进行比较，基本类型用 == ， 对象用 equals
        return (this.salary == obj.salary && Objects.equals(this.name, obj.name)
                && Objects.equals(this.hireDay, obj.hireDay));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: " + name + ", salary:" + salary + ", hirDate: " + hireDay + "]";
    }
}
