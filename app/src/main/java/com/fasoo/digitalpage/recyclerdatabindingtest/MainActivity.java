package com.fasoo.digitalpage.recyclerdatabindingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fasoo.digitalpage.recyclerdatabindingtest.databinding.ActivityMainBinding;
import com.fasoo.digitalpage.recyclerdatabindingtest.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityMainBinding.setTestRecyclerLayoutManager(linearLayoutManager);
        activityMainBinding.setMovieAdapter(new MovieAdapter());
        activityMainBinding.setViewModel(mainViewModel);
    }
}
