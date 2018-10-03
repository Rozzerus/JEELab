package com.rozzer;

import com.rozzer.manager.CoreServices;
import com.rozzer.model.Author;
import com.rozzer.model.Book;
import com.rozzer.model.Genre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SuppressWarnings("SpringFacetCodeInspection")
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        CoreServices.setServiceFactory(new DBServiceFactory());
        SpringApplication.run(Application.class, args);
    }

    /**
     * write all beans in console.
     * @param ctx spring context
     * @return bean
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            generateTestData();

        };
    }

    @Deprecated
    private void generateTestData() {
        Author author0 = newAuthor("Daria");
        Author author1 = newAuthor("Alex");
        newBook(author0, "the story of how we did the lab", Genre.STORY);
        newBook(author0, "birthday in virtual reality", Genre.EPIC);
        newBook(author0, "work without tea break", Genre.BALLAD);
        newBook(author1, "development in the TA department", Genre.MYTH);
        newBook(author1, "fuckup happened", Genre.TRAGEDY);
        newBook(author1, "red color to you", Genre.COMEDY);
    }

    private Author newAuthor(String name) {
        Author author = CoreServices.serviceFor(Author.class).create();
        author.setName(name);
        author.save();
        return author;
    }

    private void newBook(Author author, String name, Genre genre) {
        Book book = CoreServices.serviceFor(Book.class).create();
        book.setAuthor(author);
        book.setGenre(genre);
        book.setName(name);
        book.save();
    }

}
