package com.movie_data_manipulation_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Updating_One_Movie_Data{
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private String editGenre, editId, editMovieName;
    private Singleton_Input_Validation sdv;
    private Write_Command_Invoker wci;
    public Updating_One_Movie_Data(){}
    public Updating_One_Movie_Data(HashMap<String, LinkedList<Movie>> movieHashMap,
                                   Singleton_Input_Validation sdv, Write_Command_Invoker wci) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        this.wci = wci;
        System.out.println("--------------------------------------------------------");
        System.out.println("                   EDITING MOVIE DATA                   ");
        System.out.println("--------------------------------------------------------");
        data_Update();
    }
    // update the name of the movie and write the update data into CSV file
    private void data_Update() {
        Scanner sc = new Scanner(System.in);
        //request genre and id of movie
        System.out.print("Enter Movie Genre to search for edit: ");
        editGenre = sc.nextLine();
        while(!sdv.check_Genre(editGenre.trim())) {
            System.out.print("Enter Movie Genre to search for edit: ");
            editGenre = sc.nextLine();
        }
        System.out.print("Enter Movie ID to search movie: ");
        editId = sc.nextLine();
        while(!sdv.check_Id(editId.trim())) {
            System.out.print("Enter Movie ID to search movie: ");
            editId = sc.nextLine();
        }
        //check whether input movie id exits or not in input genre
        int index = -1;
        while ((index = sdv.searchGenreId(movieHashMap,editGenre,editId)) == -1){
            System.out.println("The input movie name and genre is not found!!!");
            System.out.print("Enter Movie Genre to search for edit: ");
            editGenre = sc.nextLine();
            while(!sdv.check_Genre(editGenre.trim())) {
                System.out.print("Enter Movie Genre to search for edit: ");
                editGenre = sc.nextLine();
            }

            System.out.print("Enter Movie ID to search movie: ");
            editId = sc.nextLine();
            while(!sdv.check_Id(editId.trim())) {
                System.out.print("Enter Movie ID to search movie: ");
                editId = sc.nextLine();
            }
        }
        // request update movie data from user
        System.out.print("Enter Movie Name to update: ");
        editMovieName = sc.nextLine();
        while(!sdv.check_Name(editMovieName.trim())) {
            System.out.print("Enter Movie Name to update: ");
            editMovieName = sc.nextLine();
        }
        // update new movie to the linked list of hashmap
        update(movieHashMap, editGenre, index, editMovieName);

        // write update new movie data to CSV file
        String filename = "data/movie_data/"+editGenre+".csv";

        wci.writeMovie(new Write_All_Movie(new Write_Movie(movieHashMap.get(editGenre), filename)));
        System.out.println("Update data is successfully saved.");
        System.out.println("--------------------------------------------------------");
    }

    public void update(HashMap<String, LinkedList<Movie>> movieHashMap,String editGenre, int idx, String editMovieName){
        movieHashMap.get(editGenre).get(idx).setMovieName(editMovieName);
        System.out.println("Data is successfully updated.");
    }
}
