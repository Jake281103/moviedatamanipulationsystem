package com.movie_data_manipulation_program;

import java.util.HashMap;
import java.util.LinkedList;

public interface Movie_Data {
    public void readMovieData();
    public HashMap<String,LinkedList<Movie>> getMovieData();
}
