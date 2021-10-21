package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "physique")
public class Physique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    private String description;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_animal", nullable = false, referencedColumnName = "a_id")
    private Animal animal;
}
