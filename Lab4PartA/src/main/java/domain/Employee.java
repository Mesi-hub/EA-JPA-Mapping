package domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue  //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employeeNumber")
    private int employeenumber;

    @Column(name="employeeName")
    private String name;

    @ManyToOne
    //@JoinColumn(name="department_id") // this is optional as by default N:1 uses joincolumn
    private Department department;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeenumber=" + employeenumber +
                ", name='" + name + '\'' +
                '}';
    }
}
