package com.blogspot.llrgaming.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private String[] dataTitle;
	private String[] dataRelease;
	private String[] dataProducer;
	private String[] dataGenre;
	private String[] dataDescription;
	private TypedArray dataPoster;
	private MovieAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new MovieAdapter(this);
		ListView listView = findViewById(R.id.lv_list);
		listView.setAdapter(adapter);
		
		prepare();
		addItem();
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
				Intent moveWithObject = new Intent(MainActivity.this, DetailActivity.class);
				
				ArrayList<Movie> movies = new ArrayList<>();
				
				Movie movie = new Movie();
				movie.setPoster(dataPoster.getResourceId(i, -1));
				movie.setTitle(dataTitle[i]);
				movie.setRelease(dataRelease[i]);
				movie.setProducer(dataProducer[i]);
				movie.setGenre(dataGenre[i]);
				movie.setDescription(dataDescription[i]);
				movies.add(movie);
				
				moveWithObject.putParcelableArrayListExtra(DetailActivity.EXTRA_MOVIE, movies);
				startActivity(moveWithObject);
				
			}
		});
		
	}
	
	@Override
	public void onClick(View view) {
	
	}
	
	private void prepare(){
		dataTitle = getResources().getStringArray(R.array.data_title);
		dataRelease = getResources().getStringArray(R.array.data_release);
		dataProducer = getResources().getStringArray(R.array.data_producer);
		dataGenre = getResources().getStringArray(R.array.data_genre);
		dataDescription = getResources().getStringArray(R.array.data_description);
		dataPoster = getResources().obtainTypedArray(R.array.data_poster);
		
	}
	
	private void addItem(){
		ArrayList<Movie> movies = new ArrayList<>();
		for (int i = 0; i < dataTitle.length; i++){
			Movie movie = new Movie();
			movie.setPoster(dataPoster.getResourceId(i, -1));
			movie.setTitle(dataTitle[i]);
			movie.setRelease(dataRelease[i]);
			movie.setProducer(dataProducer[i]);
			movie.setGenre(dataGenre[i]);
			movie.setDescription(dataDescription[i]);
			movies.add(movie);
		}
		adapter.setMovies(movies);
	}
}
