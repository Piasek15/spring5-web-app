package pl.piasecki.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.piasecki.spring5webapp.model.Author;
import pl.piasecki.spring5webapp.model.Book;
import pl.piasecki.spring5webapp.model.Publisher;
import pl.piasecki.spring5webapp.repositories.AuthorRepository;
import pl.piasecki.spring5webapp.repositories.BookRepository;
import pl.piasecki.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher helion = new Publisher("Helion", "Rzeszow 1234");
        Publisher cosTam = new Publisher("Cos Tam", "Krakow 1234");

        publisherRepository.save(helion);
        publisherRepository.save(cosTam);

        Author elon = new Author("Elon", "Musk");
        Book lotr = new Book("Lord of the Rings", "1234");
        lotr.setPublisher(helion);
        elon.getBooks().add(lotr);
        lotr.getAuthors().add(elon);


        authorRepository.save(elon);
        bookRepository.save(lotr);

        Author arthur = new Author("Arthur", "Kowalski");
        Book sss = new Book("Speed, Sex and Spade", "4321");
        sss.setPublisher(cosTam);
        arthur.getBooks().add(sss);


        authorRepository.save(arthur);
        bookRepository.save(sss);

    }
}
