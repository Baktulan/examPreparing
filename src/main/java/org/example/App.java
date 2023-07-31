package org.example;

import org.example.config.HibernateDataBase;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.enums.Country;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.service.PublisherService;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;
import org.example.service.serviceImpl.PublisherServiceImpl;
import org.example.service.serviceImpl.ReaderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HibernateDataBase.getEntityManager();
        PublisherService publisherService = new PublisherServiceImpl();
        AuthorServiceImpl authorService = new AuthorServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();

        Publisher publisher1 = new Publisher("Bishkek","Ankara 28");
        Publisher publisher2 = new Publisher("Nur","Togolok Moldo 33");
        Publisher publisher3 = new Publisher("KG","Sovetskaya 66");

        Author author1= new Author("Chyngyz","Aitmatov","chyngyz@gmail.ru",LocalDate.of(1948,12,1),Country.UNITED_KINGDOM,Gender.MALE);
        Author author2= new Author("Djek","London","djek@gmail.ru",LocalDate.of(1944,11,11),Country.UNITED_STATES,Gender.MALE);
        Author author3= new Author("Maria","Stephany","mari@gmail.ru",LocalDate.of(1988,3,24),Country.BRAZIL,Gender.FEMALE);
        Author author4 = new Author("Джон", "Смит", "john.smith@example.com", LocalDate.of(1975, 8, 12), Country.UNITED_STATES, Gender.MALE);
        Author author5 = new Author("Анна", "Ли", "anna.lee@example.com", LocalDate.of(1990, 11, 5), Country.JAPAN, Gender.FEMALE);
        Author author6 = new Author("Эрнест", "Хемингуэй", "ernest.hemingway@example.com", LocalDate.of(1899, 7, 21), Country.UNITED_KINGDOM, Gender.MALE);

        Book book1 = new Book("1984", Country.AUSTRALIA, LocalDate.of(1949, 6, 8), new BigDecimal("1020"), Genre.FICTION);
        Book book2 = new Book("Мастер и Маргарита", Country.GERMANY, LocalDate.of(1967, 5, 17), new BigDecimal("1250"), Genre.THRILLER);
        Book book3 = new Book("Гарри Поттер и философский камень", Country.UNITED_KINGDOM, LocalDate.of(1997, 6, 26), new BigDecimal("899"), Genre.FANTASY);
        Book book4 = new Book("Тихий дон", Country.CANADA, LocalDate.of(1940, 1, 1), new BigDecimal("1475"), Genre.HISTORICAL);
        Book book5 = new Book("Маленький принц", Country.FRANCE, LocalDate.of(1943, 4, 6), new BigDecimal("925"), Genre.POETRY);
        Book book6 = new Book("Преступление и наказание", Country.JAPAN, LocalDate.of(1866, 1, 1), new BigDecimal("7.50"), Genre.HORROR);

        Reader reader1 = new Reader("John Doe", "john.doe@example.com", 30);
        Reader reader2 = new Reader("Jane Smith", "jane.smith@example.com", 25);
        Reader reader3 = new Reader("Michael Johnson", "michael.johnson@example.com", 45);
        Reader reader4 = new Reader("Emily Davis", "emily.davis@example.com", 28);
        Reader reader5 = new Reader("David Lee", "david.lee@example.com", 35);
        Reader reader6 = new Reader("Sarah Brown", "sarah.brown@example.com", 22);



        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            num= scanner.nextInt();
            switch (num){
                case 1:{
                    System.out.println(publisherService.savePublisher(publisher3));
                    break;
                }
                case 2:{
                    System.out.println(publisherService.getPublisherById(3L));
                    break;
                }
                case 3:{
                    System.out.println(publisherService.getAllPublisher());
                    break;
                }
                case 4:{
                    System.out.println(publisherService.updatePublisher(3L, new Publisher("Jalal-Abad basmakana", "Lenin 88")));
                    break;

                }
                case 5:{
                    System.out.println(publisherService.deletePublisherByName("State"));
                    break;
                } case 6:{

                    System.out.println(authorService.saveAuthor(author5));
                    break;
                }
                case 7:{
                    System.out.println(authorService.updateAuthor(1L, new Author("Dani", "Gafurov", "dani@mail.ru", LocalDate.of(2001, 5, 18), Country.BRAZIL, Gender.MALE)));
                    break;
                }
                case 8:{
                    System.out.println(authorService.getAuthorById(2L));
                    break;
                }
                case 9:{
                    System.out.println(authorService.getAuthorByPublisherId(1L));break;
                }
                case 10:{
                    System.out.println(authorService.deleteAuthor(2L));
                    break;
                }
                case 11:{
                    System.out.println(authorService.assignAuthorToPublisher(2L, 1L));
                    break;
                }
                case 12:{
                    System.out.println(bookService.saveBook(book4,4L));

                    break;
                }
                case 13:{
                    System.out.println(bookService.updateBook(1L, new Book("Syngan Kylych", Country.GERMANY, LocalDate.of(1996, 5, 21), BigDecimal.valueOf(1300), Genre.BIOGRAPHY)));
                    break;
                }
                case 14:{
                    System.out.println(bookService.getBookAndPublisherByBookId(4L));
                    break;
                }
                case 15:{
                    System.out.println(bookService.deleteBookByAuthorId(1L));
                    break;
                }
                case 16:{
                    System.out.println(readerService.saveReader(reader6));
                    break;
                }
                case 17:{
                    System.out.println(readerService.updateReader(1L,new Reader("Baktulan","baku@mail,ru",23)));
                    break;
                }
                case 18:{
                    System.out.println(readerService.getReaderByBookId(4L));
                    break;

                }
                case 19:{
                    System.out.println(readerService.deleteReaderById(4L));
                    break;
                }
                case 20:{
                    System.out.println(readerService.getReaderByAuthorId(4L));
                    break;
//
                }
                case 21:{
                    System.out.println(publisherService.assignBookToPublisher(2L, 4L));
                    break;
                }
                case 22:{
                    System.out.println(readerService.assignBookToReader(1L, 4L));
                }
            }
        }
    }
}
