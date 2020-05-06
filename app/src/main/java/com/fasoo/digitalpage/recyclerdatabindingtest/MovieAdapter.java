package com.fasoo.digitalpage.recyclerdatabindingtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fasoo.digitalpage.recyclerdatabindingtest.databinding.ItemMovieBinding;
import com.fasoo.digitalpage.recyclerdatabindingtest.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemMovieViewHolder> {

   List<Movie> movies;

    public MovieAdapter() {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ItemMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ItemMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMovieViewHolder holder, int position) {
        holder.setItemMovieBinding(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
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
