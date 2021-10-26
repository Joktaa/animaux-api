package fr.jorisrouziere.animauxapi.controller;

import fr.jorisrouziere.animauxapi.DTO.AnimalDTO;
import fr.jorisrouziere.animauxapi.model.Animal;
import fr.jorisrouziere.animauxapi.service.AnimauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return animauxService.addAnimal(animalDTO);
    }

    @DeleteMapping("/animal/{id}")
    public void deleteAnimal(@PathVariable("id") final Long id) {
        animauxService.deleteAnimal(id);
    }
}