package fr.jorisrouziere.animauxapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animaux")
@ApiModel(description = "Animal Model")
public class Animal {

    @ApiModelProperty(notes="ID Animal", name ="id", required =true, value ="2")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id;

    @ApiModelProperty(notes="Nom commun Animal", name ="nom", required =true, value ="Coelacanthe")
    private String nom_commun;

    @ApiModelProperty(notes="Genre Animal", name ="genre", required =true, value ="Latimeria")
    private String genre;

    @ApiModelProperty(notes="Espèce Animal", name ="espece", required =true, value ="Chalumnae")
    private String espece;

    @ApiModelProperty(notes="Embranchement Animal", name ="embranchement", required =true, value ="Chordes")
    private String embranchement;

    @ApiModelProperty(notes="Sous-Embranchement Animal", name ="sous-embranchement", required =true, value ="Vertébré")
    private String sous_embranchement;

    @ApiModelProperty(notes="Ordre Animal", name ="ordre", required =true, value ="Coelocanthiforme")
    private String ordre;

    @ApiModelProperty(notes="UICN Animal", name ="uicn", required =true, value ="Danger critique d extinction")
    private String uicn;

    @ApiModelProperty(notes="Image Animal", name ="image", required =true, value ="coelacanthe")
    private String image;

    @ApiModelProperty(notes="Physiques Animal", name ="physiques", required =true, value ="[Peut dépasser les deux mètres ; Vit 48 ans]")
    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Physique> physiques;

    @ApiModelProperty(notes="Sexes Animal", name ="sexes", required =true, value ="[Les femelles sont plus grandes que les mâles]")
    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Sexe> sexes;

    @ApiModelProperty(notes="Vies Animal", name ="vies", required =true, value ="[Se réfugie souvent dans des grottes ; Chasseur nocturne]")
    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Vie> vies;

    @ApiModelProperty(notes="Reproductions Animal", name ="reproductions", required =true, value ="[ovoviviparité]")
    @JsonManagedReference
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Reproduction> reproductions;

    @ApiModelProperty(notes="Geographies Animal", name ="geographies", required =true, value ="[Afrique Est ; Océan Indien]")
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