package fr.jorisrouziere.animauxapi.service;

import fr.jorisrouziere.animauxapi.model.Animal;
import fr.jorisrouziere.animauxapi.repository.AnimauxRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AnimauxService {
    @Autowired
    private AnimauxRepository animauxRepository;

    public Iterable<Animal> getAnimaux() {
        return animauxRepository.findAll();
    }
}
