package com.blogspot.llrgaming.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
	
	String title;
	String release;
	String producer;
	String genre;
	String description;
	
	int pathPhoto;
	
	public static final String EXTRA_MOVIE = "extra_movie";
	
	TextView tTitle, tRelease, tProducer, tGenre, tDescription;
	
	ImageView iPoster;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		tTitle = findViewById(R.id.tv_title);
		tRelease = findViewById(R.id.tv_release);
		tProducer = findViewById(R.id.tv_producer);
		tGenre = findViewById(R.id.tv_genre);
		tDescription = findViewById(R.id.tv_description);
		iPoster = findViewById(R.id.img_movie);
		
		ArrayList<Movie> movies = this.getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);
		
		title = movies.get(0).getTitle();
		tTitle.setText(title);
		
		release = movies.get(0).getRelease();
		tRelease.setText(release);
		
		producer = movies.get(0).getProducer();
		tProducer.setText(producer);
		
		genre = movies.get(0).getGenre();
		tGenre.setText(genre);
		
		description = movies.get(0).getDescription();
		tDescription.setText(description);
		
		pathPhoto = movies.get(0).getPoster();
		iPoster.setImageResource(pathPhoto);
	}
}
