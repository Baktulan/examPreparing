package org.example.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Country;
import org.example.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    @SequenceGenerator(
            name = "book_gen",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Column(name = "published_year")
    private LocalDate publishedYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Author author;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Publisher publisher;

    public Book(String name, Country country, LocalDate publishedYear, BigDecimal price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", genre=" + genre +
                ", publisher=" + publisher +
                '}';
    }
}
