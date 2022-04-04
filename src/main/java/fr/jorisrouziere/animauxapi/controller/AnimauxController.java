package fr.jorisrouziere.animauxapi.controller;

import fr.jorisrouziere.animauxapi.DTO.AnimalDTO;
import fr.jorisrouziere.animauxapi.model.*;
import fr.jorisrouziere.animauxapi.service.AnimauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimauxController {
    @Autowired
    private AnimauxService animauxService;

    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable("id") final Long id) {
        Optional<Animal> animal = animauxService.getAnimal(id);
        return animal.orElse(null);
    }

    @GetMapping("/animaux")
    public Iterable<Animal> getAnimaux() {
        return animauxService.getAnimaux();
    }

    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody AnimalDTO animalDTO) {
        Animal animal = animauxService.convertDTOToEntity(animalDTO);
        return animauxService.saveAnimal(animal);
    }

    @PutMapping("/animal/{id}")
    public Animal putAnimal(@PathVariable("id") final Long id, @RequestBody AnimalDTO animalDTO) {
        Optional<Animal> animal = animauxService.getAnimal(id);
        System.out.println(animal);
        if(animal.isPresent()) {
            Animal currentAnimal = animal.get();
            Animal animalConvert= animauxService.convertDTOToEntityMapper(animalDTO);


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

            List<Physique> physiques=animalConvert.getPhysiques();
            if(physiques != null){
                currentAnimal.setPhysiques(physiques);
            }

            List<Sexe> sexes=animalConvert.getSexes();
            if(sexes != null){
                currentAnimal.setSexes(sexes);
            }

            List<Vie> vies=animalConvert.getVies();
            if(vies != null){
                currentAnimal.setVies(vies);
            }

            List<Reproduction> reproductions=animalConvert.getReproductions();
            if(reproductions != null){
                currentAnimal.setReproductions(reproductions);
            }

            List<Geographie> geographies=animalConvert.getGeographies();
            if(geographies != null){
                currentAnimal.setGeographies(geographies);
            }

            String image=animalConvert.getImage();
            if(image != null){
                currentAnimal.setImage(image);
            }

            System.out.println(animal);
            System.out.println(currentAnimal);
            animauxService.saveAnimal(currentAnimal);
            return currentAnimal;
        } else {
            return null;
        }
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable("id") final Long id) {
        animauxService.deleteAnimal(id);
    }
}