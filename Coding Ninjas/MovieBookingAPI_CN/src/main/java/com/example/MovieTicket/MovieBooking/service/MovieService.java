package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;

@Service
public class MovieService implements MovieServiceInterface{
	
	List<Movie> movieList = new ArrayList<Movie>();
	Map<String, Movie> movieMap = new HashMap<>();
	Map<String, Long> ratingsMap = new HashMap<>();
	
	@Autowired
	RatingRestCommunicator ratingRestCommunicator;

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
		Map<String, Long> ratingMap = new HashMap<>();
		ratingMap.put(id, movie.getMovieRating());
		ratingRestCommunicator.addRating(ratingMap);
		movieList.add(movie);
		movieMap.put(movie.getId(), movie);
		
	}



	@Override
	public Movie getMovieById(String id) {
		
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("This movie does not exists");
		}
		
		Movie movie =  movieMap.get(id);
		long rating = ratingRestCommunicator.getRating(id);
		
		movie.setMovieRating(rating);
		
		return movie;
	}



	@Override
	public void deleteMovie(String id) {
		if(!movieMap.containsKey(id)) { 
			throw new IdNotFound("This movie does not exists");
		}
		Movie movie = getMovieById(id);
		
		ratingRestCommunicator.deleteRating(id);
		
		movieList.remove(movie);
		movieMap.remove(id);
	}


	@Override
	public void updateMovie(Movie movie, String id) {
		if(!movieMap.containsKey(id)) {
			throw new IdNotFound("This movie does not exists");
		}
		
		Map<String, Long> ratingMap = new HashMap<>();
		ratingMap.put(id, movie.getMovieRating());
		
		ratingRestCommunicator.updateRating(ratingMap);
		
		Movie prevMovie = getMovieById(id);
		movieList.remove(prevMovie);
		movieList.add(movie);
		movieMap.put(id, movie);
		
		
		
	}
	
}
