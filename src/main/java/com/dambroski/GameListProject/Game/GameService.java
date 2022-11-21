package com.dambroski.GameListProject.Game;

import java.util.List;


public interface GameService {
	
	


	public List<Game> getAllGame();

	public Game getById(long gameId);

	public List<Game> getByName(String name);

	public Game postGame(Game game);

	public String delete(long gameId);

	public Game putGame(long gameId, Game game);

	public List<Game> getAllGamesToBuy();

	public List<Game> getAllXboxGames();

	public List<Game> getAllPlatinum();

	public List<Game> getAllPlaying();

	public List<Game> getAllToPlay();

	public List<Game> getAllXboxPlatinum();

	public List<Game> getAllXboxToBuy();

	public List<Game> findAllSwitchGames();

}
