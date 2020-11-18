package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.entity.Author;
import guru.springframework.spring5webapp.entity.Book;
import guru.springframework.spring5webapp.entity.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 12/23/19.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        System.out.println("Starting Bootstrap");
    Publisher publisher = new Publisher("publisher", "addresLine1", "Hamburg",
    "Hamburg", "12343");
    publisherRepository.save(publisher);

//        Publisher publisher = new Publisher();
//        publisher.setName("SFG Publishing");
//        publisher.setCity("St Petersburg");
//        publisher.setState("FL");
        Author shewa = new Author("Shewchenko", "Taras");
        Book zapowit = new Book("Zapowit", "12323");
        zapowit.getAuthors().add(shewa);
        shewa.getBooks().add(zapowit);
        zapowit.setPublisher(publisher);
        publisher.getBook().add(zapowit);
        authorRepository.save(shewa);
        bookRepository.save(zapowit);
        publisherRepository.save(publisher);

        Author dante = new Author("Dante Alighieri", "Hell");
        Book comedy = new Book("god's comedy", "23732");
        comedy.getAuthors().add(dante);
        dante.getBooks().add(comedy);
        publisher.getBook().add(comedy);
        authorRepository.save(dante);
        bookRepository.save(comedy);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of publisher: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBook().size());

    }
}