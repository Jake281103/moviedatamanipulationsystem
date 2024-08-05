package com.movie_data_manipulation_program;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Read_Movie implements Movie_Data{
    private String filepath;
    private HashMap<String,LinkedList<Movie>> movieHashMap;

    public Read_Movie(String filepath) {
        this.filepath = filepath;
        readMovieData();
    }
    //read data from CSV file and assign in movieHashMap
    @Override
    public void readMovieData() {
        movieHashMap = new HashMap<>();
        File folder = new File("data/movie_data");
        if (folder.exists() && folder.isDirectory()){
            File[] fileList = folder.listFiles();
            for (File file : fileList){
                try {
                    LinkedList<Movie> movieList = new LinkedList<>();
                    String[] fileName = file.getName().split("\\.");
                    FileReader fr = new FileReader(file);
                    CSVReader cr = new CSVReader(fr);
                    String[] s = cr.readNext();
                    while ((s = cr.readNext()) != null) {
                        movieList.add(new Movie(s[0],s[1],
                                (s[2].isEmpty())?"-":s[2],
                                (s[3].isEmpty())?"-":s[3],
                                (s[4].isEmpty())?"-":s[4],
                                (s[5].isEmpty())?"-":s[5],
                                (s[6].isEmpty())?"-":s[6],
                                (s[7].isEmpty())?"-":s[7],
                                (s[8].isEmpty())?"-":s[8],
                                (s[9].isEmpty())?"-":s[9]));
                    }
                    movieHashMap.put(fileName[0],movieList);
                    fr.close();
                    cr.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    // getter of movie HashMap
    @Override
    public HashMap<String, LinkedList<Movie>> getMovieData() {
        return movieHashMap;
    }
}
