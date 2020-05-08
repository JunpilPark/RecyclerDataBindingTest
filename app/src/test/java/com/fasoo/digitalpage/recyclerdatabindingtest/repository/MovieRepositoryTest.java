package com.fasoo.digitalpage.recyclerdatabindingtest.repository;

import com.fasoo.digitalpage.recyclerdatabindingtest.repository.data.Movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

@RunWith(RobolectricTestRunner.class)
class MovieRepositoryTest {

    private MovieDataSource movieDataSource;
    private List<Movie> testMovieData;

    @BeforeEach
    public void setUp() {
        testMovieData = getTestData();
        movieDataSource = new MovieDataSourceMock(testMovieData);
        // AndroidSchedulers.mainThread() 사용 시 안드로이드 종송성 때문에 Scheduler 를 변경해줘야함.
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    private List<Movie> getTestData() {
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("테스트 영화1", "테스트 주인공1", "테스트 스토리1"));
        list.add(new Movie("테스트 영화2", "테스트 주인공2", "테스트 스토리2"));
        return list;
    }

    @DisplayName("Repository에서 Movie 데이터가 정상적으로 Load 되는지 확인")
    @Test
    public void loadMoviesTest() {
        MovieRepository.getInstance(movieDataSource)
                .getMovies(new MovieDataSource.LoadMoviesCallback() {
                    @Override
                    public void onMovieLoaded(List<Movie> movie) {
                        loadMoviesTestAssertThat(movie);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        Assertions.fail();
                    }
                });
    }

    private void loadMoviesTestAssertThat(List<Movie> movies) {
        Assertions.assertIterableEquals(testMovieData, movies);
    }

}