package com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.MovieDataSourceMock;
import com.fasoo.digitalpage.recyclerdatabindingtest.repository.MovieRepository;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;
    private final MovieRepository movieRepository;

    private ViewModelFactory(MovieRepository repository) {
        this.movieRepository = repository;
    }

    public static ViewModelFactory getInstance() {
        if(INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                INSTANCE = new ViewModelFactory(
                        MovieRepository.getInstance(new MovieDataSourceMock()));
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(movieRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    };
}
