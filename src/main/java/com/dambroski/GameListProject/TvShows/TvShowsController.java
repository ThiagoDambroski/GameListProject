package com.dambroski.GameListProject.TvShows;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TvShowsController {
	
	@Autowired
	TvShowsService service;
	
	
	@GetMapping
	public List<TvShows> getAllTvShow(){
		return service.getAllTvShow();
	}
	
	@PostMapping
	public TvShows postTvShows(@RequestBody TvShows tvShows) {
		return service.postTvShows(tvShows);
	}
	
	@DeleteMapping("/delete/{tvShowId}")
	public void deleteTvShowsByid(@PathVariable("tvShowsId") long id) {
		service.deleteById(id);
	}
	
	@PutMapping("/put/{tvShowId}")
	public TvShows putTvShowsById(@RequestBody TvShows tvShows, @PathVariable("tvShowId") long id) {
		return service.putTvShowById(tvShows,id);
	}

}
