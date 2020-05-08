package com.fasoo.digitalpage.recyclerdatabindingtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fasoo.digitalpage.recyclerdatabindingtest.databinding.ActivityMainBinding;
import com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel.MainViewModel;
import com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        mainViewModel = ViewModelFactory.getInstance().create(MainViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityMainBinding.setTestRecyclerLayoutManager(linearLayoutManager);
        activityMainBinding.setMovieAdapter(new MovieAdapter());
        activityMainBinding.setViewModel(mainViewModel);
    }
}
