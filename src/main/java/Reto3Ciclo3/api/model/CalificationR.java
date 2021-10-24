package Reto3Ciclo3.api.model;

import javax.persistence.*;

@Entity
@Table(name="CalificationR")
public class CalificationR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalification;

    @Column(length = 5)
    private Double calification;

    @Column(length = 250)
    private String Message;

}
