package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "publisher_gen")
    @SequenceGenerator(
            name = "publisher_gen",
            sequenceName = "publisher_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    @ManyToMany(mappedBy = "publishers",
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH,

    },fetch = FetchType.LAZY)

    private List<Author>authors;
    @OneToMany(mappedBy = "publisher",
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    },fetch = FetchType.LAZY)
    private List<Book>books;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
