package fi.POkurssi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.POkurssi.Bookstore.domain.Book;
import fi.POkurssi.Bookstore.domain.BookRepository;
import fi.POkurssi.Bookstore.domain.Category;
import fi.POkurssi.Bookstore.domain.CategoryRepository;
import fi.POkurssi.Bookstore.domain.User;
import fi.POkurssi.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Sci-Fi"));

		brepository.save(new Book("Kirja", "Kirjoittaja", 2021, 123456, 25.00, crepository.findByName("Kauhu").get(0)));
		brepository.save(new Book("Kirj2", "Kirjoittaj2", 2020, 1234, 25.00, crepository.findByName("Fantasia").get(0)));
		
			
			System.out.println("fetch all books from db");
			for (Book book : brepository.findAll()) {
				System.out.println(book.toString());
			}
			
		System.out.println("fetch all categories from db");
			for (Category category : crepository.findAll()) {
				System.out.println(category.getName());
			}
		
		User user1 = new User("user","$2a$10$ybWFMD4JnElIM3xn6E06ZO8eAHVQfb9DhLE79DOtSi5v9PR/qyHFC", "USER");
		User user2 = new User("admin","$2a$10$pG8I4qYiz0ySak5vrCXY5ejNCLrEbOmDTUZoxAzZ.oi0Az7KNFpWu", "ADMIN");
		
				urepository.save(user1);
				urepository.save(user2);
				
				System.out.println("Fecth all usernames");
					for (User user : urepository.findAll()) {
						System.out.println(user.getUsername() + " - " + user.getRole());
					}
				
		
		};
	}
	

}
