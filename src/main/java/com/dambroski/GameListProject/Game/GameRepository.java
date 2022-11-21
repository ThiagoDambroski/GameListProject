package com.dambroski.GameListProject.Game;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	
	
	@Query("select g from Game g where g.name LIKE '%'||:name||'%'")
	public List<Game> findByName(String name);
	
	@Query("select g from Game g where g.status = 3 ")
	public List<Game> findAllGamesToBuy();
	
	@Query("select g from Game g where g.platform = 0")
	public List<Game> findAllXboxGames();
	
	@Query("select g from Game g where g.status = 1")
	public List<Game> findAllPlatinum();
	
	@Query("select g from Game g where g.status = 0")
	public List<Game> findAllPlayingGames();
	
	@Query("select g from Game g where g.status = 4")
	public List<Game> findAllToPlayGames();
	
	@Query("select g from Game g where g.status = 1 and g.platform = 0")
	public List<Game> findAllXboxPlatinum();
	
	@Query("select g from Game g where g.status = 3 and g.platform = 0")
	public List<Game> findAllXboxToBuy();
	
	@Query("select g from Game g where g.platform = 3")
	public List<Game> findAllSwitchGames();

}
