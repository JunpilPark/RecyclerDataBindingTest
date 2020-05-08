package com.fasoo.digitalpage.recyclerdatabindingtest.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.data.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDataSourceMock implements MovieDataSource {

    private List<Movie> movieArrayList;

    public MovieDataSourceMock(List<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    public MovieDataSourceMock() {
        movieArrayList = getDefaultData();
    }

    private List<Movie> getDefaultData() {
        List<Movie> movieArrayList = new ArrayList<>();
        movieArrayList.add(new Movie("영화1", "주인공1", "영화이야기1", "https://i0.wp.com/kiramonthly.com/wp-content/uploads/2020/02/1.jpg?w=1000"));
        movieArrayList.add(new Movie("영화2", "주인공2", "영화이야기2", "https://i0.wp.com/kiramonthly.com/wp-content/uploads/2020/02/1.jpg?w=1000"));
        movieArrayList.add(new Movie("영화3", "주인공3", "영화이야기3", "https://i0.wp.com/kiramonthly.com/wp-content/uploads/2020/02/1.jpg?w=1000"));
        movieArrayList.add(new Movie("영화4", "주인공4", "영화이야기4", "https://i0.wp.com/kiramonthly.com/wp-content/uploads/2020/02/1.jpg?w=1000"));

        return movieArrayList;
    }

    @Override
    public void getMovies(@NonNull final LoadMoviesCallback callback) {
        Observable.just(movieArrayList)
                .delay(3, TimeUnit.SECONDS, Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> {
                    Log.d("jppark", "[MovieDataSourceMock - getMovies]: onComplete!!");
                })
                .subscribe(callback::onMovieLoaded);
    }
}
