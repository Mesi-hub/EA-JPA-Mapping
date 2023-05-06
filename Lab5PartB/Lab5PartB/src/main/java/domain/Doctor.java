package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
	@GeneratedValue
	private int id;
	@Column(name = "type")
    private String doctorType;
    private String firstName;
    private String lastName;

    public Doctor() {
    }

    public Doctor(String doctorType, String firstName, String lastName) {
        this.doctorType = doctorType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	@Override
	public String toString() {
		return "Doctor{" +
				"id=" + id +
				", doctorType='" + doctorType + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
