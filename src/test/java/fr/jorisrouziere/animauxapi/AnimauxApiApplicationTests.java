package fr.jorisrouziere.animauxapi;

import fr.jorisrouziere.animauxapi.DTO.AnimalDTO;
import fr.jorisrouziere.animauxapi.model.Animal;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnimauxApiApplicationTests {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void ConvertAnimauxEntityToDto_ok(){
        Animal animal = new Animal();
        animal.setA_id(1L);
        animal.setNom_commun("chien");
        animal.setImage("chien");

        AnimalDTO animalDTO = modelMapper.map(animal, AnimalDTO.class);
        assertEquals(animal.getA_id(), animalDTO.getA_id());
        assertEquals(animal.getNom_commun(), animal.getNom_commun());
        assertEquals(animal.getImage(), animal.getImage());
    }

    /*@Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle(randomAlphabetic(6));
        post.setUrl("www.test.com");

        PostDto postDto = modelMapper.map(post, PostDto.class);
        assertEquals(post.getId(), postDto.getId());
        assertEquals(post.getTitle(), postDto.getTitle());
        assertEquals(post.getUrl(), postDto.getUrl());
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle(randomAlphabetic(6));
        postDto.setUrl("www.test.com");

        Post post = modelMapper.map(postDto, Post.class);
        assertEquals(postDto.getId(), post.getId());
        assertEquals(postDto.getTitle(), post.getTitle());
        assertEquals(postDto.getUrl(), post.getUrl());
    }*/

}
