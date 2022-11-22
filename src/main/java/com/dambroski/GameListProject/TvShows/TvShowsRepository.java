package com.dambroski.GameListProject.TvShows;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowsRepository extends JpaRepository<TvShows, Long> {
	
	@Query("select t from TvShows t where t.name LIKE '%'||:name||'%' ")
	List<TvShows> findByName(@Param("name") String name);

}
