package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.OrderRepository;

import java.util.Iterator;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order o1 = createOrder1();
		Order o2 = createOrder2();
		Order o3 = createOrder3();
		Order o4 = createOrder4();


		orderRepository.save(o1);
		orderRepository.save(o2);
		orderRepository.save(o3);
		orderRepository.save(o4);


		Optional<Order> orderOpt = orderRepository.findById(1L);
		Order order = orderOpt.get();
		printOrder2(order);
	}


	public static void printOrder2(Order order){
		System.out.println("Order with orderNumber: "+order.getOrdernr());
		System.out.println("Order date: "+order.getDate());
		System.out.println("Order status: "+order.getStatus());
		Customer cust=order.getCustomer();
		System.out.println("Customer: "+cust.getFirstname()+" "+cust.getLastname());
		System.out.println("Address: "+cust.getAddress().getStreet()+" "+cust.getAddress().getCity()+" "+cust.getAddress().getZip());

		Iterator iter = order.getOrderlines().iterator();
		while (iter.hasNext()) {
			OrderLine orderline = (OrderLine) iter.next();
			System.out.println("Order line: quantity= " + orderline.getQuantity());
			System.out.println(orderline.getProduct());
		}
	}

	private static Order createOrder1() {
		Customer c1 = new Customer("Frank", "Brown");
		Address a1= new Address("Mainstreet 1", "New york", "43221");
		c1.setAddress(a1);
		Book book = new Book();
		book.setIsbn("1243");
		book.setProductNumber("B1111");
		book.setName("Hibernate 3");

		book.setPrice(35.50);

		OrderLine ol1= new OrderLine(2);
		ol1.setProduct(book);

		CD cd = new CD();
		cd.setProductNumber("C1122");
		cd.setName("The best of Queen");
		cd.setPrice(12.98);
		cd.setArtist("Queen");
		OrderLine ol2= new OrderLine(4);
		ol2.setProduct(cd);

		Order o1 = new Order("234743","12/10/06","open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.setCustomer(c1);
		return o1;
	}

	private static Order createOrder2() {
		Customer c1 = new Customer("John", "Doe");
		Address a1= new Address("Hoofdstraat 1", "Amsterdam", "2318KL");
		c1.setAddress(a1);
		Book book = new Book();
		book.setProductNumber("B1133");
		book.setIsbn("345764");
		book.setName("Spring 2");
		book.setPrice(35.50);

		OrderLine ol1= new OrderLine(2);
		ol1.setProduct(book);

		CD cd = new CD();
		cd.setProductNumber("C1144");
		cd.setName("The best of Queen");
		cd.setPrice(12.98);
		cd.setArtist("Queen");
		OrderLine ol2= new OrderLine(1);
		ol2.setProduct(cd);

		CD cd2 = new CD();
		cd2.setProductNumber("C1155");
		cd2.setName("The best of U2");
		cd2.setPrice(16.98);
		cd2.setArtist("U2");
		OrderLine ol3= new OrderLine(1);
		ol3.setProduct(cd2);

		CD cd3 = new CD();
		cd3.setProductNumber("C1166");
		cd3.setName("U2 Live");
		cd3.setPrice(9.96);
		cd3.setArtist("U2");
		OrderLine ol4= new OrderLine(1);
		ol4.setProduct(cd3);

		DVD dvd = new DVD();
		dvd.setProductNumber("C1177");
		dvd.setName("IL DIVO Live");
		dvd.setPrice(15.98);
		dvd.setGenre("POP");
		OrderLine ol5= new OrderLine(1);
		ol5.setProduct(dvd);

		Order o1 = new Order("231678","12/12/06","closed");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);
		o1.addOrderLine(ol4);
		o1.addOrderLine(ol5);
		o1.setCustomer(c1);
		return o1;
	}

	private static Order createOrder3() {
		Customer c1 = new Customer("Mary", "Johnson");
		Address a1= new Address("Mainstreet 1", "Boston", "82554");
		c1.setAddress(a1);
		Book book = new Book();
		book.setProductNumber("B1177");
		book.setIsbn("234432");
		book.setName("J2ee design");
		book.setPrice(49.00);

		OrderLine ol1= new OrderLine(2);
		ol1.setProduct(book);



		DVD dvd = new DVD();
		dvd.setProductNumber("D1188");
		dvd.setName("IL DIVO Live");
		dvd.setPrice(15.98);
		dvd.setGenre("POP");
		OrderLine ol3= new OrderLine(1);
		ol3.setProduct(dvd);

		Order o1 = new Order("555743","12/10/06","open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol3);
		o1.setCustomer(c1);
		return o1;
	}

	private static Order createOrder4() {
		Customer c1 = new Customer("Meseret", "Amare");
		Address a1= new Address("1000N 4th St", "Fairfield", "52577");
		c1.setAddress(a1);

		Book book = new Book();
		book.setIsbn("123432");
		book.setProductNumber("B1188");
		book.setName("J2ee design");
		book.setPrice(49.00);

		OrderLine ol1= new OrderLine(2);
		ol1.setProduct(book);



		DVD dvd = new DVD();
		dvd.setProductNumber("D1199");
		dvd.setName("Rocky3");
		dvd.setPrice(8.98);
		dvd.setGenre("drama");
		OrderLine ol3= new OrderLine(1);
		ol3.setProduct(dvd);

		Order o1 = new Order("555744","12/10/06","open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol3);
		o1.setCustomer(c1);
		return o1;
	}
}
