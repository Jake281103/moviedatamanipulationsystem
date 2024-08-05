package com.movie_data_manipulation_program;

import java.util.HashMap;
import java.util.LinkedList;

public class Proxy_Read_Movie implements Movie_Data{
    private Read_Movie readMovie;
    private HashMap<String,LinkedList<Movie>> movieHashMap;;
    private String filepath;

    public Proxy_Read_Movie(String filepath) {
        this.filepath = filepath;
        readMovieData();
    }
    // create Read_Movie Object or assign movie hash map with getter method of Read_Movie Object
    @Override
    public void readMovieData() {
        if(readMovie == null) {
            readMovie = new Read_Movie(filepath);
        }
        movieHashMap = readMovie.getMovieData();
    }
    // getter of movie HashMap
    @Override
    public HashMap<String, LinkedList<Movie>> getMovieData() {
        return movieHashMap;
    }
}
