package chapter4objectandclass.paramTest;

/**
 * 测试方法参数的使用情况：总是按值调用
 * 一个方法不能修改一个基本数据类型的参数
 * 一个方法可以改变一个对象参数的状态（因为这个方法可以用过对象引用的拷贝修改所引用的对象状态，对象引用即new操作符返回的值，并不是对象本身）
 * 一个方法不能让对象参数引用一个新的对象
 */
public class ParamTest {
    public static void main(String[] args) {
        // test param
        int param = 10;
        System.out.println("before test param:" + param);
        changeParam(param);
        System.out.println("after test param:" + param);

        // test instance
        Employee employee = new Employee("employee", 100.5);
        System.out.println("before test instance, salary:" + employee.getSalary());
        changeInstance(employee);
        System.out.println("after test instance, salary:" + employee.getSalary());

        // test swap instance
        Employee bob = new Employee("bob", 100.5);
        Employee jack = new Employee("jack", 201.9);
        System.out.println("before swap instance, bob.name:" + bob.getName() + ", jack.name:" + jack.getName());
        swapInstance(bob, jack);
        System.out.println("after swap instance, bob.name:" + bob.getName() + ", jack.name:" + jack.getName());
    }

    public static void changeParam(int param) {
        param = param * 3;
        System.out.println("change param:" + param);
    }

    public static void changeInstance(Employee employee) {
        employee.setSalary(employee.getSalary() * 3);
        System.out.println("change instance param:" + employee.getSalary());
    }

    public static void swapInstance(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("swap instance x.name:" + x.getName());
        System.out.println("swap instance y.name:" + y.getName());
    }


}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addSalary(double present) {
        salary = salary * present / 100;
        System.out.println("add salary: " + salary);
    }
}

