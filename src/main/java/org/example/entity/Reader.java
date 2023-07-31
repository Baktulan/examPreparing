package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "readers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reader_gen")
    @SequenceGenerator(
            name = "reader_gen",
            sequenceName = "reader_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String email;
    private int age;
    @OneToOne( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH
    })
    private Book book;

    public Reader(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
