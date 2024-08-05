package com.movie_data_manipulation_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Display_Total_Movies_Producing_Each_Year_Each_Genre{
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private String displayGenre, displayYear;
    private Singleton_Input_Validation sdv;
    public Display_Total_Movies_Producing_Each_Year_Each_Genre(){}
    public Display_Total_Movies_Producing_Each_Year_Each_Genre(HashMap<String, LinkedList<Movie>> movieHashMap,
                                                               Singleton_Input_Validation sdv) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        System.out.println("-------------------------------------------------------------");
        System.out.println("         TOTAL MOVIES PRODUCING EACH YEAR EACH GENRE         ");
        System.out.println("-------------------------------------------------------------");
        data_Display();
    }
    // report total movies producing each year each genre
    private void data_Display() {
        Scanner sc = new Scanner(System.in);
        //requesting genre to display the movie data
        System.out.print("Enter movie Genre to know total movie producing: ");
        displayGenre = sc.nextLine();
        while(!sdv.check_Genre(displayGenre.trim())) {
            System.out.print("Enter movie Genre to know total movie producing: ");
            displayGenre = sc.nextLine();
        }
        //requesting year to display the movie data
        System.out.print("Enter Year to know total movie producing: ");
        displayYear = sc.nextLine();
        while(!sdv.check_Year(displayYear.trim())) {
            System.out.print("Enter Year to know total movie producing: ");
            displayYear = sc.nextLine();
        }
        //check whether the report year exists or not in report genre
        while (!sdv.searchGenreYear(movieHashMap,displayGenre,displayYear)){
            System.out.println("Input movie genre and year is not found!!!");
            //requesting genre to display the movie data
            System.out.print("Enter movie Genre to know total movie producing: ");
            displayGenre = sc.nextLine();
            while(!sdv.check_Genre(displayGenre.trim())) {
                System.out.print("Enter movie Genre to know total movie producing: ");
                displayGenre = sc.nextLine();
            }
            //requesting year to display the movie data
            System.out.print("Enter Year to know total movie producing: ");
            displayYear = sc.nextLine();
            while(!sdv.check_Year(displayYear.trim())) {
                System.out.print("Enter Year to know total movie producing: ");
                displayYear = sc.nextLine();
            }
        }

        // count and display the number of movie producing of each genre in each year
        System.out.println("The total " + displayGenre + " movie production of " + displayYear + " is " + count(movieHashMap,displayGenre,displayYear));
    }

    public int count(HashMap<String, LinkedList<Movie>> movieHashMap,String displayGenre, String displayYear){
        int count = 0;
        for (Movie mv : movieHashMap.get(displayGenre)){
            if (displayYear.equals(mv.getYear())){
                count++;
            }
        }
        return count;
    }
}
