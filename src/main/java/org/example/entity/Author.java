package org.example.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Country;
import org.example.enums.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "author_gen")
    @SequenceGenerator(
            name = "author_gen",
            sequenceName = "author_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dataOfBirth;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "author",
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Book>books;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE
    })
    private List<Publisher>publishers;

    public Author(String firstName, String lastName, String email, LocalDate dataOfBirth, Country country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dataOfBirth = dataOfBirth;
        this.country = country;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                ", country=" + country +
                ", gender=" + gender +
                '}';
    }
}
