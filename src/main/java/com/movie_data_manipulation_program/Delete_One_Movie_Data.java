package com.movie_data_manipulation_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Delete_One_Movie_Data{

    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private String deleteGenre, deleteId;
    private Singleton_Input_Validation sdv;
    private Write_Command_Invoker wci;
    public Delete_One_Movie_Data(){}
    public Delete_One_Movie_Data(HashMap<String, LinkedList<Movie>> movieHashMap,
                                 Singleton_Input_Validation sdv, Write_Command_Invoker wci) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        this.wci = wci;
        System.out.println("--------------------------------------------------------");
        System.out.println("                 DELETING ONE MOVIE DATA                ");
        System.out.println("--------------------------------------------------------");
        data_Delete();
    }
    // delete movie from movie hashmap and write in csv file
    private void data_Delete() {
        Scanner sc = new Scanner(System.in);
        //request genre and id of movie
        System.out.print("Enter Movie Genre to search for edit: ");
        deleteGenre = sc.nextLine();
        while(!sdv.check_Genre(deleteGenre.trim())) {
            System.out.print("Enter Movie Genre to search for edit: ");
            deleteGenre = sc.nextLine();
        }

        System.out.print("Enter Movie ID to search movie: ");
        deleteId = sc.nextLine();
        while(!sdv.check_Id(deleteId.trim())) {
            System.out.print("Enter Movie ID to search movie: ");
            deleteId = sc.nextLine();
        }
        //check whether delete movie id exit or not in delete year
        int index = -1;
        while ((index = sdv.searchGenreId(movieHashMap,deleteGenre,deleteId)) == -1){
            System.out.println("The input movie name and genre is not found!!!");
            System.out.print("Enter Movie Genre to search for edit: ");
            deleteGenre = sc.nextLine();
            while(!sdv.check_Genre(deleteGenre.trim())) {
                System.out.print("Enter Movie Genre to search for edit: ");
                deleteGenre = sc.nextLine();
            }

            System.out.print("Enter Movie ID to search movie: ");
            deleteId = sc.nextLine();
            while(!sdv.check_Id(deleteId.trim())) {
                System.out.print("Enter Movie ID to search movie: ");
                deleteId = sc.nextLine();
            }
        }

        System.out.print("Are you sure to delete this movie data?Y/N: ");
        char option = sc.next().charAt(0);
        if (Character.toUpperCase(option) == 'Y'){
            // delete movie from the linked list of hashmap
            remove(movieHashMap,deleteGenre,index);

            String filename = "data/movie_data/"+deleteGenre+".csv";

            wci.writeMovie(new Write_All_Movie(new Write_Movie(movieHashMap.get(deleteGenre), filename)));
            System.out.println("--------------------------------------------------------");
        }
    }

    public void remove(HashMap<String, LinkedList<Movie>> movieHashMap,String deleteGenre, int idx){
        movieHashMap.get(deleteGenre).remove(idx);
        System.out.println("Data is successfully Deleted.");
    }
}
