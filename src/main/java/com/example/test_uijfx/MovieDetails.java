package com.example.test_uijfx;
import com.google.gson.Gson;

public class MovieDetails {

    int id;
    String poster_path;
    String backdrop_path;
    String overview;
    String title;
    Double vote_average;

    int vote_count;


    //Standard Getters and Setters

    public String getPosterPath(){return poster_path;}
    public void setPoster_path(String poster_path) {this.poster_path = poster_path;}

    public int getId(){return id;}
    public void setId(int id) {this.id = id;}
    public String getBackdrop_path() {return backdrop_path;}

    public void setBackdrop_path(String backdrop_path) {this.backdrop_path = backdrop_path;}
    public String getOverview() {return overview;}

    public void setOverview(String overview) {this.overview = overview;}
    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Double getVote_average() {return vote_average;}

    public void setVote_average(Double vote_average) {this.vote_average = vote_average;}

    public int getVote_count() {return vote_count;}

    public void setVote_count(int vote_count) {this.vote_count = vote_count;}


    //Deserialize the json string ..

    public static MovieDetails[] fromJson(String json) {
        Gson gson = new Gson();
        moiveResponse movieList = gson.fromJson(json, moiveResponse.class);
        return movieList.results;
    }
}

