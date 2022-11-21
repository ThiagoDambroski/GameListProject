package com.dambroski.GameListProject.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GameServiceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	GameRepository repository;
	
	@Autowired
	GameService service;
	
	Optional<Game> game = Optional.of(Game.builder().name("Gow").gameId((long) 1).status(Status.PLAYING).
			platform(Platform.PLAYSTATION).time("0").build());

	
	@Test
	public void findGameById() throws Exception {
		Mockito.when(repository.findById((long)1)).thenReturn(game);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/game/byId/1")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))
					.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(game.get().getName())));
	}
	
	@Test
	public void findGameByName() throws Exception {
		List<Game> list = new ArrayList<>();
		list.add(game.get());
		Mockito.when(repository.findByName("gow")).thenReturn(list);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/game/byName/gow")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(game.get().getName())));
	}
	
	@Test
	public void postGame() throws JsonProcessingException, Exception {
		
		Mockito.when(repository.save(game.get())).thenReturn(game.get());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/game/post")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(game.get())))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(game.get().getName())));
		
	}
	
	@Test
	public void deleteGame() throws Exception {
		Mockito.when(repository.findById(game.get().getGameId())).thenReturn(game);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/game/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void putGame() throws JsonProcessingException, Exception {
		Game newGame = Game.builder().name("mario").gameId((long) 1).status(Status.PLAYING).
				platform(Platform.SWITCH).time("0").build();
		
		Mockito.when(repository.findById(game.get().getGameId())).thenReturn(game);
		Mockito.when(repository.save(newGame)).thenReturn(newGame);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/game/put/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(newGame)))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(newGame.getName())));
	}
	
	
	
}
