package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    private String image;

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

    public Animal(String nom_commun, String genre, String espece, String embranchement, String sous_embranchement, String ordre, String uicn, String image) {
        this.nom_commun = nom_commun;
        this.genre = genre;
        this.espece = espece;
        this.embranchement = embranchement;
        this.sous_embranchement = sous_embranchement;
        this.ordre = ordre;
        this.uicn = uicn;
        this.image = image;
    }
}