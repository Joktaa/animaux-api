package fr.jorisrouziere.animauxapi.service;

import fr.jorisrouziere.animauxapi.DTO.*;
import fr.jorisrouziere.animauxapi.model.*;
import fr.jorisrouziere.animauxapi.repository.AnimauxRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimauxService {
    @Autowired
    private AnimauxRepository animauxRepository;

    public Iterable<Animal> getAnimaux() {
        return animauxRepository.findAll();
    }

    public Animal addAnimal(AnimalDTO animalDTO) {
        return animauxRepository.save(convertDTOToEntity(animalDTO));
    }

    public Animal convertDTOToEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal(
                animalDTO.getNom_commun(),
                animalDTO.getGenre(),
                animalDTO.getEspece(),
                animalDTO.getEmbranchement(),
                animalDTO.getSous_embranchement(),
                animalDTO.getOrdre(),
                animalDTO.getUicn()
        );

        List<Physique> physiques = new ArrayList<>();
        for (PhysiqueDTO physiqueDTO : animalDTO.getPhysiques()) {
            physiques.add(new Physique(physiqueDTO.getDescription(), animal));
        }
        animal.setPhysiques(physiques);

        List<Sexe> sexes = new ArrayList<>();
        for (SexeDTO sexeDTO : animalDTO.getSexes()) {
            sexes.add(new Sexe(sexeDTO.getDescription(), animal));
        }
        animal.setSexes(sexes);

        List<Vie> vies = new ArrayList<>();
        for (VieDTO vieDTO : animalDTO.getVies()) {
            vies.add(new Vie(vieDTO.getDescription(), animal));
        }
        animal.setVies(vies);

        List<Reproduction> reproductions = new ArrayList<>();
        for (ReproductionDTO reproductionDTO : animalDTO.getReproductions()) {
            reproductions.add(new Reproduction(reproductionDTO.getDescription(), animal));
        }
        animal.setReproductions(reproductions);

        List<Geographie> geographies = new ArrayList<>();
        for (GeographieDTO geographieDTO : animalDTO.getGeographies()) {
            geographies.add(new Geographie(geographieDTO.getDescription(), animal));
        }
        animal.setGeographies(geographies);

        return animal;
    }
}
