package domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    private int id;
    private int flightnumber;

    @Column(name ="flight_from")
    private String from;

    @Column(name ="flight_to")
    private String to;

    @Column(name = "flight_date")
    private Date date;

//    @ManyToOne
//    private Passenger passenger;

    public Flight() {
    }

    public Flight(int flightnumber, String from, String to, Date date) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }
}
