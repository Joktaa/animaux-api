package fr.jorisrouziere.animauxapi.controller;

import fr.jorisrouziere.animauxapi.model.Animal;
import fr.jorisrouziere.animauxapi.service.AnimauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnimauxController {
    @Autowired
    private AnimauxService animauxService;

    @GetMapping("/animaux")
    public Iterable<Animal> getAnimaux() {
        return animauxService.getAnimaux();
    }
}