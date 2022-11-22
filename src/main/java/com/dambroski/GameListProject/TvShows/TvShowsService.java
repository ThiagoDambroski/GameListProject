package com.dambroski.GameListProject.TvShows;

import java.util.List;

public interface TvShowsService {

	List<TvShows> getAllTvShow();

	TvShows postTvShows(TvShows tvShows);

	void deleteById(long id);

	TvShows putTvShowById(TvShows tvShows, long id);

	void addOneEp(long id);

	void subOneEp(long id);

	TvShows getTvShowById(long id);

	List<TvShows> getTvShowByName(String name);

}
