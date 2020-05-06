package com.fasoo.digitalpage.recyclerdatabindingtest;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.fasoo.digitalpage.recyclerdatabindingtest.databinding.ItemMovieBinding;
import com.fasoo.digitalpage.recyclerdatabindingtest.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemMovieViewHolder> {

    List<Movie> movies;

    @NonNull
    @Override
    public ItemMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemMovieViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMovieViewHolder holder, int position) {
        holder.setItemMovieBinding(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.size();
    }

    @BindingAdapter("app:setAdapter")
    public static void setAdapter(RecyclerView recyclerView, MovieAdapter movieAdapter) {
        recyclerView.setAdapter(movieAdapter);
    }

    @BindingAdapter("app:itemBind")
    public static void itemBinding(RecyclerView recyclerView, LiveData<List<Movie>> movies) {
        Log.d("jppark", "itemBinding " + (movies.getValue() == null ? 0 : movies.getValue().size()));
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter instanceof MovieAdapter) {
            ((MovieAdapter) adapter).setItems(movies.getValue());
        }
    }

    public void setItems(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    public class ItemMovieViewHolder extends RecyclerView.ViewHolder {
        ItemMovieBinding itemMovieBinding;

        public ItemMovieViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            itemMovieBinding = binding;
        }

        public void setItemMovieBinding(Movie movie) {
            itemMovieBinding.setVariable(BR.movie, movie);
            itemMovieBinding.executePendingBindings();
        }
    }
}
