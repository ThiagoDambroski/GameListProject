package com.dambroski.GameListProject.Game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService service;
	
	
	@GetMapping
	public List<Game> getAllGame() {
		return service.getAllGame();
	}
	
	@GetMapping("/byId/{gameId}")
	public Game getById(@PathVariable("gameId") long gameId) {
		return service.getById(gameId);
	}
	
	@GetMapping("/byName/{name}")
	public List<Game> getByName(@PathVariable("name") String name) {
		return service.getByName(name);
		
	}
	
	@GetMapping("/all/toBuy")
	public List<Game> getAllGamesToBuy(){
		return service.getAllGamesToBuy();
	}
	
	@GetMapping("/all/platinum")
	public List<Game> getAllPlatinum(){
		return service.getAllPlatinum();
	}
	
	@GetMapping("/all/Playing")
	public List<Game> getAllPlaying(){
		return service.getAllPlaying();
	}
	
	@GetMapping("/all/toPlay")
	public List<Game> getAllToPlay(){
		return service.getAllToPlay();
	}
	
	@GetMapping("/xbox/all")
	public List<Game> getAllXboxGames(){
		return service.getAllXboxGames();
	}
	
	@GetMapping("/xbox/platinum")
	public List<Game> getAllXboxPlatinum(){
		return service.getAllXboxPlatinum();
	}
	
	@GetMapping("/xbox/toBuy")
	public List<Game> getAllToBuyXbox(){
		return service.getAllXboxToBuy();
	}
	
	@GetMapping("/switch/all")
	public List<Game> getAllSwitchGames(){
		return service.findAllSwitchGames();
	}
	
	
	@PostMapping("/post")
	public Game postGame(@RequestBody Game game) {
		return service.postGame(game);
		
	}
	
	@DeleteMapping("/delete/{gameId}")
	public String deleteGame(@PathVariable("gameId") long gameId) {
		return service.delete(gameId);
	}
	
	@PutMapping("/put/{gameId}")
	public Game putGame(@PathVariable("gameId") long gameId, @RequestBody Game game) {
		return service.putGame(gameId,game);
	}

}
