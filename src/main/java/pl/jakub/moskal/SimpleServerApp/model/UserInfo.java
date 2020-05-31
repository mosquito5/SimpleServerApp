package pl.jakub.moskal.SimpleServerApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserInfo")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", length = 32)
    private String name;

    @Column(name = "Surname", length = 32)
    private String surname;

    @Column(name = "Phone", length = 12)
    private String phone;

    @Column(name = "City", length = 32)
    private String City;
}
