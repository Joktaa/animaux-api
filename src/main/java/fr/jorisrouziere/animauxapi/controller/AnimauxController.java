package fr.jorisrouziere.animauxapi.controller;

import fr.jorisrouziere.animauxapi.DTO.AnimalDTO;
import fr.jorisrouziere.animauxapi.model.*;
import fr.jorisrouziere.animauxapi.service.AnimauxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value= "/api", tags = "Animaux Api")
@RequestMapping("/api")
public class AnimauxController {
    @Autowired
    private AnimauxService animauxService;


    @GetMapping("/animal/{id}")
    @ApiOperation(value = "Récupère l'animal passé en paramètre", response = Animal.class)
    public Animal getAnimal(@PathVariable("id") final Long id) {
        Optional<Animal> animal = animauxService.getAnimal(id);
        return animal.orElse(null);
    }

    @GetMapping("/animaux")
    @ApiOperation(value = "Récupère tous les animaux", response = Iterable.class)
    public Iterable<Animal> getAnimaux() {
        return animauxService.getAnimaux();
    }

    @PostMapping("/animal")
    @ApiOperation(value = "Créer un animal", response = Animal.class)
    public Animal addAnimal(@RequestBody AnimalDTO animalDTO) {
        Animal animal = animauxService.convertDTOToEntity(animalDTO);
        return animauxService.saveAnimal(animal);
    }

    @PutMapping("/animal/{id}")
    @ApiOperation(value = "Modifier un animal", response = Animal.class)
    public Animal putAnimal(@PathVariable("id") final Long id, @RequestBody AnimalDTO animalDTO) {
        Optional<Animal> animal = animauxService.getAnimal(id);
        if(animal.isPresent()) {
            Animal currentAnimal = animal.get();
            Animal animalConvert= animauxService.convertDTOToEntity(animalDTO);


            String nom_commun=animalConvert.getNom_commun();
            if(nom_commun != null){
                currentAnimal.setNom_commun(nom_commun);
            }
            String genre=animalConvert.getGenre();
            if(genre != null){
                currentAnimal.setGenre(genre);
            }
            String espece=animalConvert.getEspece();
            if(espece != null){
                currentAnimal.setEspece(espece);
            }
            String embranchement=animalConvert.getEmbranchement();
            if(embranchement != null){
                currentAnimal.setEmbranchement(embranchement);
            }
            String sous_embranchement=animalConvert.getSous_embranchement();
            if(sous_embranchement != null){
                currentAnimal.setSous_embranchement(sous_embranchement);
            }
            String ordre=animalConvert.getOrdre();
            if(ordre != null){
                currentAnimal.setOrdre(ordre);
            }
            String uicn=animalConvert.getUicn();
            if(uicn != null){
                currentAnimal.setUicn(uicn);
            }

            if(currentAnimal.getPhysiques().get(0) != null){
                List<Physique> physiques = new ArrayList<>();
                Physique newPhysique = currentAnimal.getPhysiques().get(0);
                newPhysique.setDescription(animalConvert.getPhysiques().get(0).getDescription());
                physiques.add(newPhysique);

                currentAnimal.setPhysiques(physiques);
            }


            if(currentAnimal.getSexes().get(0) != null){
                List<Sexe> sexes = new ArrayList<>();
                Sexe newSexe = currentAnimal.getSexes().get(0);
                newSexe.setDescription(animalConvert.getSexes().get(0).getDescription());
                sexes.add(newSexe);

                currentAnimal.setSexes(sexes);
            }

            if(currentAnimal.getVies().get(0) != null){
                List<Vie> vies = new ArrayList<>();
                Vie newVie = currentAnimal.getVies().get(0);
                newVie.setDescription(animalConvert.getVies().get(0).getDescription());
                vies.add(newVie);

                currentAnimal.setVies(vies);
            }

            if(currentAnimal.getReproductions().get(0) != null){
                List<Reproduction> reproductions = new ArrayList<>();
                Reproduction newReproduction = currentAnimal.getReproductions().get(0);
                newReproduction.setDescription(animalConvert.getReproductions().get(0).getDescription());
                reproductions.add(newReproduction);

                currentAnimal.setReproductions(reproductions);
            }

            if(currentAnimal.getGeographies().get(0) != null){
                List<Geographie> geographies = new ArrayList<>();
                Geographie newGeographie = currentAnimal.getGeographies().get(0);
                newGeographie.setDescription(animalConvert.getGeographies().get(0).getDescription());
                geographies.add(newGeographie);

                currentAnimal.setGeographies(geographies);
            }

            String image=animalConvert.getImage();
            if(image != null){
                currentAnimal.setImage(image);
            }

            animauxService.saveAnimal(currentAnimal);
            return currentAnimal;
        } else {
            return null;
        }
    }

    @DeleteMapping("/animal/{id}")
    @ApiOperation(value = "Supprime l'animal passé en paramètre", response = void.class)
    public void deleteAnimal(@PathVariable("id") final Long id) {
        animauxService.deleteAnimal(id);
    }
}