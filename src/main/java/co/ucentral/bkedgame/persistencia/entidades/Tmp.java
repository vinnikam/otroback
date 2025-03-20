package co.ucentral.bkedgame.persistencia.entidades;

import jakarta.persistence.*;

@Entity
public class Tmp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
