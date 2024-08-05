package com.movie_data_manipulation_program;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;

public class Write_Movie {

    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private LinkedList<Movie> movieLinkedList;
    private String filePath;
    //constructors with different types of parameters
    public Write_Movie(HashMap<String, LinkedList<Movie>> movieHashMap, String filePath) {
        this.movieHashMap = movieHashMap;
        this.filePath = filePath;
    }
    public Write_Movie(LinkedList<Movie> movieLinkedList, String filePath) {
        this.movieLinkedList = movieLinkedList;
        this.filePath = filePath;
    }
    //method for writing all movie data to the CSV file based on the input
    public void writeAllMovie() {
        File folder = new File(filePath);
        if (folder.exists() && folder.isDirectory()){
            File[] fileList = folder.listFiles();
            for (File file : fileList){
                try {
                    String[] fileName = file.getName().split("\\.");
                    FileWriter fw = new FileWriter(file, false);
                    CSVWriter csvw = new CSVWriter(fw);
                    csvw.writeNext(new String[]{"movie_id","movie_name","year","certificate","runtime","rating","director","star","votes","gross(in $)"});
                    for(Movie mv: movieHashMap.get(fileName[0])) {
                        String[] newMovie = {mv.getMovieId(), mv.getMovieName(), mv.getYear(), mv.getCertificate(), mv.getRuntime(), mv.getRating(),
                                mv.getDirector(), mv.getStar(), mv.getVotes(), mv.getGross()};
                        csvw.writeNext(newMovie);
                    }
                    csvw.close();
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();;
                }
            }
        }
        else {
            try {
                FileWriter fw = new FileWriter(folder, false);
                CSVWriter csvw = new CSVWriter(fw);
                csvw.writeNext(new String[]{"movie_id","movie_name","year","certificate","runtime","rating","director","star","votes","gross(in $)"});
                for(Movie mv: movieLinkedList) {
                    String[] newMovie = {mv.getMovieId(), mv.getMovieName(), mv.getYear(), mv.getCertificate(), mv.getRuntime(), mv.getRating(),
                            mv.getDirector(), mv.getStar(), mv.getVotes(), mv.getGross()};
                    csvw.writeNext(newMovie);
                }
                csvw.close();
                fw.close();
            }catch (Exception e){
                e.printStackTrace();;
            }
        }
    }
    ///method for writing append movie data to the CSV file based on the input
    public void writeAppendMovie() {
        File folder = new File(filePath);
        if (folder.exists() && folder.isDirectory()){
            File[] fileList = folder.listFiles();
            for (File file : fileList){
                try {
                    String[] fileName = file.getName().split("\\.");
                    FileWriter fw = new FileWriter(file, true);
                    CSVWriter csvw = new CSVWriter(fw);
                    for(Movie mv: movieHashMap.get(fileName[0])) {
                        String[] newMovie = {mv.getMovieId(), mv.getMovieName(), mv.getYear(), mv.getCertificate(), mv.getRuntime(), mv.getRating(),
                                mv.getDirector(), mv.getStar(), mv.getVotes(), mv.getGross()};
                        csvw.writeNext(newMovie);
                    }
                    csvw.close();
                    fw.close();
                }catch (Exception e){
                    e.printStackTrace();;
                }
            }
        }
    }
}
