package com.dambroski.GameListProject.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
	
	
	@Id
	@SequenceGenerator(name = "game_sequence",sequenceName = "game_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
	private Long gameId;
	
	private String name;
	
	private Status status;
	
	private Platform platform;
	
	private String time;
	
	

}
