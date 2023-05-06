package domain;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // Getters and Setters
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // Default fetch type of 1:N is LAZY
    //@Fetch(FetchMode.SUBSELECT)
    /* CascadeType.PERSIST => Saving Department in the DB, also save corresponding Employee at the same time.*/
    private List<Employee> employees = new ArrayList<Employee>();
public void addEmployees (Employee e){
        employees.add(e);
    }

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
