package com.dambroski.GameListProject.TvShows;

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
public class TvShows {
	

	@Id
	@SequenceGenerator(name = "tv_sequence",sequenceName = "tv_sequence",allocationSize = 1)
	@GeneratedValue(generator = "tv_sequence",strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	
	private int epNumber;
	
	private int epWatched;
	
	private StatusTv status;
}
