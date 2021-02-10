package fi.POkurssi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.POkurssi.Bookstore.domain.Book;
import fi.POkurssi.Bookstore.domain.BookRepository;
import fi.POkurssi.Bookstore.domain.Category;
import fi.POkurssi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
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
		};
	}
	

}
