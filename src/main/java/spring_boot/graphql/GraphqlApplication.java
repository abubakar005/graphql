package spring_boot.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring_boot.graphql.model.Author;
import spring_boot.graphql.model.Book;
import spring_boot.graphql.repository.AuthorRepository;
import spring_boot.graphql.repository.BookRepository;

@SpringBootApplication
public class GraphqlApplication {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer() {
		return args -> {
			// Create authors
			Author author1 = new Author();
			author1.setName("George Orwell");
			author1.setNationality("British");

			Author author2 = new Author();
			author2.setName("J.K. Rowling");
			author2.setNationality("British");

			// Save authors to the database
			authorRepository.save(author1);
			authorRepository.save(author2);

			// Create books
			Book book1 = new Book();
			book1.setTitle("1984");
			book1.setGenre("Dystopian");
			book1.setAuthor(author1);

			Book book2 = new Book();
			book2.setTitle("Animal Farm");
			book2.setGenre("Political Satire");
			book2.setAuthor(author1);

			Book book3 = new Book();
			book3.setTitle("Harry Potter and the Philosopher's Stone");
			book3.setGenre("Fantasy");
			book3.setAuthor(author2);

			Book book4 = new Book();
			book4.setTitle("Harry Potter and the Chamber of Secrets");
			book4.setGenre("Fantasy");
			book4.setAuthor(author2);

			// Save books to the database
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
		};
	}
}
