package com.fasoo.digitalpage.recyclerdatabindingtest.repository;

import androidx.annotation.NonNull;

public class MovieRepository implements MovieDataSource {

    private MovieDataSource dataSource;
    private volatile static MovieRepository INSTANCE = null;

    public static MovieRepository getInstance(MovieDataSource movieDataSource) {
        synchronized (MovieRepository.class) {
            if (INSTANCE == null) {
                INSTANCE = new MovieRepository(movieDataSource);
            }
        }
        return INSTANCE;
    }

    private MovieRepository(@NonNull MovieDataSource movieDataSource) {
        this.dataSource = movieDataSource;
    }

    @Override
    public void getMovies(@NonNull LoadMoviesCallback callback) {
        dataSource.getMovies(callback);
    }
}
