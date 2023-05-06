package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // Getters and Setters
@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

   // @OneToMany(mappedBy = "passenger", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @OrderColumn(name="sequence")  //check with   @OrderColumn
    @JoinColumn(name = "passenger")
    private List<Flight> flights = new ArrayList<Flight>();
public void addFlights (Flight flight){
        flights.add(flight);
    }

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
