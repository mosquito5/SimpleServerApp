package pl.jakub.moskal.SimpleServerApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Author", length = 32)
    private String author;

    @Column(name = "Description", length = 512)
    private String description;
}
