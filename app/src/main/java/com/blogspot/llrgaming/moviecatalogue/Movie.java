package com.blogspot.llrgaming.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
	
	private String title;
	private String release;
	private String producer;
	private String genre;
	private String description;
	private int poster;
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public String getTitle() {
	
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRelease() {
		return release;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPoster() {
		return poster;
	}
	
	public void setPoster(int poster) {
		this.poster = poster;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.title);
		dest.writeString(this.release);
		dest.writeString(this.producer);
		dest.writeString(this.genre);
		dest.writeString(this.description);
		dest.writeInt(this.poster);
	}
	
	public Movie(){
	
	}
	
	protected Movie(Parcel in) {
		this.title = in.readString();
		this.release = in.readString();
		this.producer = in.readString();
		this.genre = in.readString();
		this.description = in.readString();
		this.poster = in.readInt();
	}
	
	public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
		@Override
		public Movie createFromParcel(Parcel source) {
			return new Movie(source);
		}
		
		@Override
		public Movie[] newArray(int size) {
			return new Movie[size];
		}
	};
}
