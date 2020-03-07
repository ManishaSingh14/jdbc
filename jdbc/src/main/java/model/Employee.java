package model;

public class Employee {
   private int id;
   private String name;
   private String city;
   private int age;
   private String deptName;

    public Employee(int id, String name, String city, int age, String deptName) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}