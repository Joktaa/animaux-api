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

    public Animal addAnimal(Animal animal) {
        return animauxRepository.save(animal);
    }

    public void deleteAnimal(final Long id) {
        animauxRepository.deleteById(id);
    }

    public Animal convertDTOToEntity(AnimalDTO animalDTO) {
        return modelMapper.map(animalDTO, Animal.class);
    }

    public AnimalDTO convertEntityToDTO(Animal animal) {

        return modelMapper.map(animal, AnimalDTO.class);
    }

}
