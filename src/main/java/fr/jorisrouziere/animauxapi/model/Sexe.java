package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sexe")
public class Sexe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;

    private String description;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_animal", nullable = false, referencedColumnName = "a_id")
    private Animal animal;

    public Sexe(String description, Animal animal) {
        this.description = description;
        this.animal = animal;
    }
}
