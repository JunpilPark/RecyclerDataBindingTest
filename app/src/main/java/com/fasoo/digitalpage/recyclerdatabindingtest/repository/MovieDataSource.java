package com.fasoo.digitalpage.recyclerdatabindingtest.repository;

import androidx.annotation.NonNull;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.data.Movie;

import java.util.List;

public interface MovieDataSource {

    interface LoadMoviesCallback {
        void onMovieLoaded(List<Movie> movie);
        void onDataNotAvailable();
    }

    void getMovies(@NonNull LoadMoviesCallback callback);
}
