package fr.jorisrouziere.animauxapi.service;

import fr.jorisrouziere.animauxapi.DTO.*;
import fr.jorisrouziere.animauxapi.model.*;
import fr.jorisrouziere.animauxapi.repository.AnimauxRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimauxService {
    @Autowired
    private AnimauxRepository animauxRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Iterable<Animal> getAnimaux() {
        return animauxRepository.findAll();
    }

    public Optional<Animal> getAnimal(final Long id) {
        return animauxRepository.findById(id);
    }

    public Animal addAnimal(AnimalDTO animalDTO) {
        return animauxRepository.save(convertDTOToEntity(animalDTO));
    }

    public void deleteAnimal(final Long id) {
        animauxRepository.deleteById(id);
    }

    public Animal convertDTOToEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal(
                animalDTO.getNom_commun(),
                animalDTO.getGenre(),
                animalDTO.getEspece(),
                animalDTO.getEmbranchement(),
                animalDTO.getSous_embranchement(),
                animalDTO.getOrdre(),
                animalDTO.getUicn(),
                animalDTO.getImage()
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

    public AnimalDTO convertEntityToDTO(Animal animal) {

        return modelMapper.map(animal, AnimalDTO.class);
    }

}
