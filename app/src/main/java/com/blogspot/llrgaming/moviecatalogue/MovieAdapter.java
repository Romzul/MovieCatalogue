package com.blogspot.llrgaming.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Movie> movies;
	
	public void setMovies(ArrayList<Movie> movies){
		this.movies = movies;
	}
	
	public MovieAdapter(Context context){
		this.context = context;
		movies = new ArrayList<>();
	}
	
	@Override
	public int getCount() {
		return movies.size();
	}
	
	@Override
	public Object getItem(int i) {
		return movies.get(i);
	}
	
	@Override
	public long getItemId(int i) {
		return i;
	}
	
	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		if (view == null);{
			view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
		}
		ViewHolder viewHolder = new ViewHolder(view);
		Movie movies = (Movie) getItem(i);
		viewHolder.bind(movies);
		return view;
	}
	
	private class ViewHolder {
		private TextView txtTitle, txtRelease, txtProducer, txtGenre, txtDescription;
		private ImageView imgMovie;
		
		ViewHolder(View view){
			txtTitle = view.findViewById(R.id.tv_title);
			txtRelease = view.findViewById(R.id.tv_release);
			txtProducer = view.findViewById(R.id.tv_producer);
			txtGenre = view.findViewById(R.id.tv_genre);
			txtDescription = view.findViewById(R.id.tv_description);
			imgMovie = view.findViewById(R.id.img_movie);
		}
		
		void bind(Movie movies){
			txtTitle.setText(movies.getTitle());
			txtRelease.setText(movies.getRelease());
			txtProducer.setText(movies.getProducer());
			txtGenre.setText(movies.getGenre());
			txtDescription.setText(movies.getDescription());
			imgMovie.setImageResource(movies.getPoster());
		}
	}
}
