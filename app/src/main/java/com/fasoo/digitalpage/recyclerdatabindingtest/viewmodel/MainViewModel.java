package com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Movie>> _movies = new MutableLiveData<>();
    private List<Movie> movies = new ArrayList<>();

    public LiveData<List<Movie>> getMovies() {
        return _movies;
    }

    public void addMovie() {
        movies.add(new Movie("test" + getRandom(), "test1, test2", "test000"));
        _movies.setValue(movies);
    }

    private long getRandom() {
        return Math.round((Math.random() * 1000) / 10);
    }
}
