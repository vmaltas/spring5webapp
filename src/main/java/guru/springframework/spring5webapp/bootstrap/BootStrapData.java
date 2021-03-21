package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author jrrr = new Author("JRRR", "Tolkien");
        Book lotr = new Book("LOTR", "123");
        jrrr.getBooks().add(lotr);
        lotr.getAuthors().add(jrrr);

        authorRepository.save(jrrr);
        bookRepository.save(lotr);

        Author neil = new Author("Neil", "Gailman");
        Book sandman = new Book("Sandman", "456");
        neil.getBooks().add(sandman);
        sandman.getAuthors().add(neil);

        authorRepository.save(neil);
        bookRepository.save(sandman);

        System.out.println("Server Started");
        System.out.println("Number of books" + bookRepository.count());


    }
}
