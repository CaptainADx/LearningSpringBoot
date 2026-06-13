package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;

@Service
public class MovieService implements MovieServiceInterface{
	
	List<Movie> movieList = new ArrayList<Movie>();
	Map<String, Movie> movieMap = new HashMap<>();
	
	

	@Override
	public List<Movie> getAllMovies() {
		return movieList;
	}
	
	

	@Override	
	public void addMovie(Movie movie) {
		String id = movie.getId();
		
		if(movieMap.containsKey(id)) {
			throw new IdAlreadyExist("This movie already Exists");
		}
		
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);
		
	}



	@Override
	public Movie getMovieById(String id) {
		
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("This movie does not exists");
		}
		return movieMap.get(id);
	}



	@Override
	public void deleteMovieById(String id) {
		if(!movieMap.containsKey(id)) { 
			throw new IdNotFound("This movie does not exists");
		}
		Movie movie = getMovieById(id);
		movieList.remove(movie);
		movieMap.remove(id);
	}


	@Override
	public void updateMovie(Movie movie, String id) {
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("This movie does not exists");
		}
		
		Movie prevMovie = getMovieById(id);
		movieList.remove(prevMovie);
		movieList.add(movie);
		movieMap.put(id, movie);
		
	}
	
}
