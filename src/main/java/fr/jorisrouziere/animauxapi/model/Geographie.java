package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "geographie")
public class Geographie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long g_id;

    private String description;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_animal", nullable = false, referencedColumnName = "a_id")
    private Animal animal;
}
