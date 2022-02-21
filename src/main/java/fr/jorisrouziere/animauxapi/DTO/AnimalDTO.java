package fr.jorisrouziere.animauxapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AnimalDTO {
    private String nom_commun;
    private String genre;
    private String espece;
    private String embranchement;
    private String sous_embranchement;
    private String ordre;
    private String uicn;
    private List<PhysiqueDTO> physiques;
    private List<SexeDTO> sexes;
    private List<VieDTO> vies;
    private List<ReproductionDTO> reproductions;
    private List<GeographieDTO> geographies;
    private String image;
}
