package fr.jorisrouziere.animauxapi.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AnimalDTO {

    @ApiModelProperty(notes="ID Animal", name ="id", required =true, value ="2")
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
    private List<PhysiqueDTO> physiques;

    @ApiModelProperty(notes="Sexes Animal", name ="sexes", required =true, value ="[Les femelles sont plus grandes que les mâles]")
    private List<SexeDTO> sexes;

    @ApiModelProperty(notes="Vies Animal", name ="vies", required =true, value ="[Se réfugie souvent dans des grottes ; Chasseur nocturne]")
    private List<VieDTO> vies;

    @ApiModelProperty(notes="Reproductions Animal", name ="reproductions", required =true, value ="[ovoviviparité]")
    private List<ReproductionDTO> reproductions;

    @ApiModelProperty(notes="Geographies Animal", name ="geographies", required =true, value ="[Afrique Est ; Océan Indien]")
    private List<GeographieDTO> geographies;

}
