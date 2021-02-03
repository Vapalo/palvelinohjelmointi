package fi.POkurssi.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.POkurssi.Bookstore.domain.Book;
import fi.POkurssi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Kirja", "Kirjoittaja", 2021, 123456, 25.00));
			
			System.out.println("fetch all books from db");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}
	

}
