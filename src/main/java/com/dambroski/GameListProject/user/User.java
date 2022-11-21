package com.dambroski.GameListProject.user;

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
public class User {
	
	@Id
	@SequenceGenerator(name = "user_id",sequenceName = "user_sequence",allocationSize = 1)
	@GeneratedValue(generator = "user_id",strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String name;
	
	private String email;
	
	private String pdw;
	

}
