package com.dambroski.GameListProject.TvShows;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvShowServiceImpl implements TvShowsService {
	
	@Autowired
	TvShowsRepository repository;

	@Override
	public List<TvShows> getAllTvShow() {
		return repository.findAll();
	}

	@Override
	public TvShows postTvShows(TvShows tvShows) {
		
		return repository.save(tvShows);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public TvShows putTvShowById(TvShows tvShows, long id) {
		TvShows newTvShows = repository.findById(id).get();
		
		if(Objects.nonNull(tvShows.getName()) && !"".equals(tvShows.getName())) {
			newTvShows.setName(tvShows.getName());
		}
		
		if(Objects.nonNull(tvShows.getStatus())) {
			newTvShows.setStatus(tvShows.getStatus());
		}
		
		if(Objects.nonNull(tvShows.getEpNumber())) {
			newTvShows.setEpNumber(tvShows.getEpNumber());
		}
		if(Objects.nonNull(tvShows.getEpWatched())) {
			newTvShows.setEpWatched(tvShows.getEpWatched());
		}
		
		
		
		return repository.save(newTvShows);
	}

}
