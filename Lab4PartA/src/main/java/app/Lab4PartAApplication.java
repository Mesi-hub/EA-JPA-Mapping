package app;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.DepartmentRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Lab4PartAApplication implements CommandLineRunner {

    @Autowired
    DepartmentRepository departmentRepository; //a
    @Autowired
    BookRepository bookRepository; // b
    @Autowired
    PassengerRepository passengerRepository; //c
    @Autowired
    SchoolRepository schoolRepository; //d

//    @Autowired
//    EmployeeRepository employeeRepository;

     public static void main(String[] args) {
        SpringApplication.run(Lab4PartAApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("Software Engineering");

        Employee emp1 = new Employee("Meseret");
        Employee emp2 = new Employee("Abebe");
        Employee emp3 = new Employee("Elias");


        dept1.addEmployees(emp1);
        dept2.addEmployees(emp2);
        dept2.addEmployees(emp3);

        emp1.setDepartment(dept1);
        emp2.setDepartment(dept1);
        emp3.setDepartment(dept2);

        departmentRepository.save(dept1);
        departmentRepository.save(dept2);


        // fetch all departments
        System.out.println("Department found with findAll():");
        System.out.println("-------------------------------");
        for (Department department : departmentRepository.findAll()) {
            System.out.println(department);
        }
        System.out.println();

        // fetch an individual customer by ID
        Optional<Department> deptOpt = departmentRepository.findById(1);
        Department department = deptOpt.get();
        System.out.println("Department found with the given ID:");
        System.out.println("--------------------------------");
        System.out.println(department);
        System.out.println();


        //Create and save book and publisher

        Book book1 = new Book("1122", "Enterprize Architecture", "Payman");
        Publisher publisher1 = new Publisher("M.I.U.");
        book1.setPublisher(publisher1);

        Book book2 = new Book("2222", "Enterprize Architecture", "Payman");
        Publisher publisher2 = new Publisher("O'Reilly");
        book2.setPublisher(publisher2);

        bookRepository.save(book1);
        bookRepository.save(book2);


        Optional<Book> optBook = bookRepository.findById(1);
        Book getbooks = optBook.get();
        System.out.println(getbooks);

        //Create and persist passengers and flights

        Flight flight1 = new Flight(1111,"Bole", "Prague", new Date());
        Flight flight2 = new Flight(1122,"Istanbul", "New York", new Date());
        Flight flight3 = new Flight(1133,"Chicago", "Paris", new Date());
        Flight flight4 = new Flight(1144,"Bole", "Nairobi", new Date());
        Flight flight5 = new Flight(1155,"Paris", "Chicago", new Date());
        Flight flight6 = new Flight(1156,"Bahir Dar", "Vienna", new Date());
        Passenger passenger1 = new Passenger("Meseret");
        Passenger passenger2 = new Passenger("Dereje");

     //order preservation // TODO - check the DB
        passenger1.addFlights(flight4);
        passenger1.addFlights(flight3);
        passenger1.addFlights(flight2);
        passenger1.addFlights(flight1);
        passenger2.addFlights(flight6);
        passenger2.addFlights(flight5);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);


        Optional<Passenger> passengerOpt = passengerRepository.findById(2);
        Passenger pass = passengerOpt.get();
        System.out.println(pass);

        //Create and persist students and school info

        Student student1 = new Student(101, "Meseret","Amare");
        Student student2 = new Student(102, "Dereje","Yihun");
        School school = new School("M.I.U");
        school.addStudent(student1);
        school.addStudent(student2);

        schoolRepository.save(school);


        Optional<School> schoolOpt = schoolRepository.findById(1L);
        School school2 = schoolOpt.get();
        System.out.println(school2);

    }



}
