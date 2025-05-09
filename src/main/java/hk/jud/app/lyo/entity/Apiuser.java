package hk.jud.app.lyo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "apiuser")
@Data
public class Apiuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}