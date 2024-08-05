package com.movie_data_manipulation_program;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Singleton_Input_Validation {
    private static final Singleton_Input_Validation inputValidation = new Singleton_Input_Validation();

    private Singleton_Input_Validation(){}
    //checking input filepath
    public boolean check_File(String filepath) {
        File f = new File(filepath);

        //checking the file is existed
        if (!f.exists()) {
            System.out.println("File does not exist.");
            return false;
        }

        //checking the file is not empty
        if (f.length() == 0) {
            System.out.println("File has no data.");
            return false;
        }
        return true;
    }
    // checking input movie id
    public boolean check_Id(String id) {
        //checking  id is not empty
        if(id.isEmpty()) {
            System.out.println("Movie Id is empty.");
            return false;
        }

        //checking the id is only one word
        if(id.contains(" ")) {
            System.out.println("Movie Id must be in one word.");
            return false;
        }

        //checking the id has not contained number
        if(!id.matches("tt[0-9]+")) {
            System.out.println("Movie Id formation start with tt and next are 0 to 9");
            return false;
        }
        return true;
    }
    // checking input movie genre
    public boolean check_Genre(String genre) {
        //checking the genre is not empty
        if(genre.isEmpty()) {
            System.out.println("Movie Genre is empty.");
            return false;
        }

        //checking the genre is only one word
        if(genre.contains(" ")) {
            System.out.println("Movie Genre must be in one word.");
            return false;
        }

        //checking the name has not contained number
        if(!genre.matches("[^A-Z]+")) {
            System.out.println("Movie genre formation start with small letter");
            return false;
        }
        return true;
    }
    //checking input movie year
    public boolean check_Year(String year) {
        //checking the year is not empty
        if(year.isEmpty()) {
            System.out.println("Year is empty.");
            return false;
        }
        if (!year.matches("[1-9][0-9]{3}")){
            System.out.println("Year must be in 4 digit number");
            return false;
        }
        return true;
    }
    // checking input movie name
    public boolean check_Name(String name){
        //checking the Name is not empty
        if(name.isEmpty()) {
            System.out.println("Name is empty.");
            return false;
        }
        if (!name.matches("([A-Z]|[0-9])[\\w\\s]*")){
            System.out.println("Movie Name start with Upper Letter or Digits");
            return false;
        }
        return true;
    }
    //check whether input movie id exits or not in input genre
    public int searchGenreId(HashMap<String, LinkedList<Movie>> movieHashMap, String editGenre, String editId){
        int index = 0;
        for (String key : movieHashMap.keySet()){
            if (key.equals(editGenre)){
                for (Movie mv : movieHashMap.get(key)){
                    if (editId.equals(mv.getMovieId())){
                        return index;
                    }
                    index++;
                }
            }
        }
        return -1;
    }
    //check whether input year exits or not in input genre
    public boolean searchGenreYear(HashMap<String, LinkedList<Movie>> movieHashMap, String genre, String year){
        for (String key : movieHashMap.keySet()){
            if (key.equals(genre)){
                for (Movie mv : movieHashMap.get(key)){
                    if (year.equals(mv.getYear())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //getter method of Singleton_Input_Validation object
    public static Singleton_Input_Validation get_Input_Validation() {
        return inputValidation;
    }
}
