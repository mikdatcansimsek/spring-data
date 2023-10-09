package yte.intern.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		saveBooks(bookRepository);

		//System.out.println(bookRepository.findByTitle("Clean Code"));
		//System.out.println(bookRepository.findByAgeGreaterThan(15L, Sort.by("age").ascending()));
		//System.out.println(bookRepository.findByPublishDateAfter(LocalDateTime.parse("1950-01-01T00:00"), PageRequest.of(0, 5)));
		//System.out.println(bookRepository.findByTitleContainsIgnoreCase("clean"));
		//System.out.println(bookRepository.findByAuthorAndAgeGreaterThan("Robert C. Martin", 10L));
		//System.out.println(bookRepository.countByAuthor("Robert C. Martin"));
		//System.out.println(bookRepository.existsByAuthor("Martin Fowler"));
	}

	private static void saveBooks(BookRepository bookRepository){
		List<Book> exampleBooks = new ArrayList<>();

		exampleBooks.add(new Book(null,"Clean Code", "Robert C. Martin", 11L, LocalDateTime.parse("2008-07-11T00:00")));
		exampleBooks.add(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", 0L, LocalDateTime.parse("1925-04-10T00:00")));
		exampleBooks.add(new Book(null, "To Kill a Mockingbird", "Harper Lee", 15L, LocalDateTime.parse("1960-07-11T00:00")));
		exampleBooks.add(new Book(null, "The Lord of the Rings", "J.R.R. Tolkien", 11L, LocalDateTime.parse("1954-07-29T00:00")));
		exampleBooks.add(new Book(null, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 3L, LocalDateTime.parse("1997-06-26T00:00")));
		exampleBooks.add(new Book(null, "1984", "George Orwell", 30L, LocalDateTime.parse("1949-06-08T00:00")));
		exampleBooks.add(new Book(null, "The Catcher in the Rye", "J.D. Salinger", 23L, LocalDateTime.parse("1951-07-16T00:00")));
		exampleBooks.add(new Book(null, "Pride and Prejudice", "Jane Austen", 7L, LocalDateTime.parse("1813-01-28T00:00")));

		bookRepository.saveAll(exampleBooks);

	}

}
