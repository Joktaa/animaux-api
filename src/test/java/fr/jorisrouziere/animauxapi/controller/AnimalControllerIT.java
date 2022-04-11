package fr.jorisrouziere.animauxapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.jorisrouziere.animauxapi.model.*;
import fr.jorisrouziere.animauxapi.service.AnimauxService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AnimauxService animauxService;

    //TODO se mettre d'accord sur le premier animal
    @Test
    public void getEmployees_OK() throws Exception {

        ResultActions result = mockMvc.perform(get("/animaux").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());

    }

    @Test
    public void getEmploye_OK() throws Exception {

        ResultActions result = mockMvc.perform(get("/animal/1").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    public void postDeleteEmploye_OK() throws Exception {

        Animal animal = new Animal();
        animal.setNom_commun("test");
        animal.setImage("test");

        List<Physique> physiques = new ArrayList<>();
        Physique physique = new Physique();
        physique.setP_id(2L);
        physique.setAnimal(animal);
        physique.setDescription("test");
        physiques.add(physique);
        animal.setPhysiques(physiques);

        List<Sexe> sexes = new ArrayList<>();
        Sexe sexe = new Sexe();
        sexe.setS_id(2L);
        sexe.setAnimal(animal);
        sexe.setDescription("test");
        sexes.add(sexe);
        animal.setSexes(sexes);

        List<Vie> vies = new ArrayList<>();
        Vie vie = new Vie();
        vie.setV_id(2L);
        vie.setAnimal(animal);
        vie.setDescription("test");
        vies.add(vie);
        animal.setVies(vies);

        List<Reproduction> reproductions = new ArrayList<>();
        Reproduction reproduction = new Reproduction();
        reproduction.setR_id(2L);
        reproduction.setAnimal(animal);
        reproduction.setDescription("test");
        reproductions.add(reproduction);
        animal.setReproductions(reproductions);

        List<Geographie> geographies = new ArrayList<>();
        Geographie geographie = new Geographie();
        geographie.setG_id(2L);
        geographie.setAnimal(animal);
        geographie.setDescription("test");
        geographies.add(geographie);
        animal.setGeographies(geographies);

        ObjectMapper objectMapper = new ObjectMapper();

        String animalStr = objectMapper.writeValueAsString(animal);

        ResultActions resultActions = mockMvc.perform(post("/animal").contentType(MediaType.APPLICATION_JSON).content(animalStr));
        resultActions.andExpect(status().isOk());

        Iterable<Animal> iterable = animauxService.getAnimaux();

        List<Animal> animals = new ArrayList<>();
        iterable.forEach(animals::add);

        Assertions.assertEquals(animals.get(animals.size()-1).getNom_commun(),animal.getNom_commun());

        animauxService.deleteAnimal(animals.get(animals.size()-1).getA_id());

        Iterable<Animal> iterable2 = animauxService.getAnimaux();

        List<Animal> animals2 = new ArrayList<>();
        iterable2.forEach(animals2::add);

        Assertions.assertNotEquals(animals,animals2);
    }

}
