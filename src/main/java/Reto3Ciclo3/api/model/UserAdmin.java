package Reto3Ciclo3.api.model;

import javax.persistence.*;

@Entity
@Table(name="UserAdmin")
public class UserAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column(length = 250)
    private String name;

}
