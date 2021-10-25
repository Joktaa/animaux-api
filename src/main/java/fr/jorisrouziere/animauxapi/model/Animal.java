package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animaux")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id;

    private String nom_commun;

    private String genre;

    private String espece;

    private String embranchement;

    private String sous_embranchement;

    private String ordre;

    private String uicn;

    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Physique> physiques;

    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Sexe> sexes;

    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Vie> vies;

    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Reproduction> reproductions;

    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Geographie> geographies;
}