package com.example.MovieTicket.MovieBooking.service;

import java.util.List;

import com.example.MovieTicket.MovieBooking.Model.Movie;

public interface MovieServiceInterface {
	public List<Movie> getAllMovies();
	public void addMovie(Movie movie);
	public Movie getMovieById(String id);
	public void deleteMovieById(String id);
	public void updateMovie(Movie movie, String id);
}
