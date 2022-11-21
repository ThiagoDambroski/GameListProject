package com.dambroski.GameListProject.Game;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository repository;
	
	@Override
	public List<Game> getAllGame() {
		return repository.findAll();
	}
	
	@Override
	public Game getById(long gameId) {
		return repository.findById(gameId).get();
	}

	@Override
	public List<Game> getByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Game postGame(Game game) {
		return repository.save(game);
	}

	@Override
	public String delete(long gameId) {
		repository.deleteById(gameId);
		return "Game " + gameId + " delete with sucess";
	}

	@Override
	public Game putGame(long gameId, Game game) {
		Game newGame = repository.findById(gameId).get();
		if(Objects.nonNull(game.getName())&& !"".equals(game.getName())){
			newGame.setName(game.getName());
		}
		if(Objects.nonNull(game.getStatus())){
			newGame.setStatus(game.getStatus());
		}
		if(Objects.nonNull(game.getTime())&& !"".equals(game.getTime())) {
			newGame.setTime(game.getTime());
		}
		if(Objects.nonNull(game.getPlatform())) {
			newGame.setPlatform(game.getPlatform());
		}
		return repository.save(newGame);
	}

	@Override
	public List<Game> getAllGamesToBuy() {
		return repository.findAllGamesToBuy();
	}

	@Override
	public List<Game> getAllXboxGames() {
		return repository.findAllXboxGames();
	}

	@Override
	public List<Game> getAllPlatinum() {
		return repository.findAllPlatinum();
	}

	@Override
	public List<Game> getAllPlaying() {
		return repository.findAllPlayingGames() ;
	}

	@Override
	public List<Game> getAllToPlay() {
		return repository.findAllToPlayGames();
	}

	@Override
	public List<Game> getAllXboxPlatinum() {
		return repository.findAllXboxPlatinum();
	}

	@Override
	public List<Game> getAllXboxToBuy() {
		// TODO Auto-generated method stub
		return repository.findAllXboxToBuy();
	}

	@Override
	public List<Game> findAllSwitchGames() {
		// TODO Auto-generated method stub
		return repository.findAllSwitchGames();
	}

}
