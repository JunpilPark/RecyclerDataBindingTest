package com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.MovieDataSource;
import com.fasoo.digitalpage.recyclerdatabindingtest.repository.MovieRepository;
import com.fasoo.digitalpage.recyclerdatabindingtest.repository.data.Movie;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> _movies = new MutableLiveData<>();
    private MovieRepository movieRepository;

    public MainViewModel(MovieRepository repository) {
        movieRepository = repository;
        loadData();
    }

    private void loadData() {
        movieRepository.getMovies(new MovieDataSource.LoadMoviesCallback() {
            @Override
            public void onMovieLoaded(List<Movie> movie) {
                _movies.postValue(movie);
            }

            @Override
            public void onDataNotAvailable() {
                Log.e("jppark", "[MainViewModel - onDataNotAvailable]: Movie Data load Error in movie Repository. ");
            }
        });
    }

    public LiveData<List<Movie>> getMovies() {
        return _movies;
    }

}
