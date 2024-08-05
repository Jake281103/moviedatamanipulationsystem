package com.movie_data_manipulation_program;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class Display_Top_5_Rated_Movie_Each_Genre_Each_Year{
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private String displayGenre, displayYear;
    private Singleton_Input_Validation sdv;
    public Display_Top_5_Rated_Movie_Each_Genre_Each_Year(){}
    public Display_Top_5_Rated_Movie_Each_Genre_Each_Year(HashMap<String, LinkedList<Movie>> movieHashMap,
                                                          Singleton_Input_Validation sdv) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        System.out.println("--------------------------------------------------------");
        System.out.println("         Top 5 RATED MOVIE EACH GENRE EACH YEAR         ");
        System.out.println("--------------------------------------------------------");
        data_Display();
    }
    // report Top 5 RATED MOVIE EACH GENRE EACH YEAR
    private void data_Display() {
        Scanner sc = new Scanner(System.in);
        //requesting genre to display the movie data
        System.out.print("Enter movie Genre to report movie data: ");
        displayGenre = sc.nextLine();
        while(!sdv.check_Genre(displayGenre.trim())) {
            System.out.print("Enter movie Genre to report movie data: ");
            displayGenre = sc.nextLine();
        }
        //requesting year to display the movie data
        System.out.print("Enter Year to report movie data: ");
        displayYear = sc.nextLine();
        while(!sdv.check_Year(displayYear.trim())) {
            System.out.print("Enter Year to report movie data: ");
            displayYear = sc.nextLine();
        }
        //check whether the report year exists or not in report genre
        while (!sdv.searchGenreYear(movieHashMap,displayGenre,displayYear)){
            System.out.println("Input movie genre and year is not found!!!");
            //requesting genre to display the movie data
            System.out.print("Enter movie Genre to report movie data: ");
            displayGenre = sc.nextLine();
            while(!sdv.check_Genre(displayGenre.trim())) {
                System.out.print("Enter movie Genre to report movie data: ");
                displayGenre = sc.nextLine();
            }
            //requesting year to display the movie data
            System.out.print("Enter Year to report movie data: ");
            displayYear = sc.nextLine();
            while(!sdv.check_Year(displayYear.trim())) {
                System.out.print("Enter Year to report movie data: ");
                displayYear = sc.nextLine();
            }
        }
        //creating report linked list
        LinkedList<Movie> reportList = new LinkedList<>();
        for (Movie mv : movieHashMap.get(displayGenre)){
            if (displayYear.equals(mv.getYear())){
                reportList.add(mv);
            }
        }

        // sort the report linked list
        LinkedList<Movie> sortedList = sort(reportList);

        //display data from report linked list with asciiTable
        System.out.println("Top Five Rated Movies Of "+this.displayGenre + " in " +this.displayYear);
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(Arrays.asList("MOVIE ID","MOVIE ID","YEAR","CERTIFICATE","RUNTIME","RATING","DIRECTOR","STARS","VOTES","GROSS(in $)"));
        at.addRule();
        CWC_LongestLine cwc = new CWC_LongestLine();
        at.getRenderer().setCWC(cwc);
        for (int index = 0; index <5 && index < sortedList.size(); index++){
            Movie mv = sortedList.get(index);
            at.addRow(Arrays.asList(mv.getMovieId(),mv.getMovieName(),mv.getYear(),mv.getCertificate(),mv.getRuntime(),mv.getRating(),mv.getDirector(),
                    mv.getStar(),mv.getVotes(),mv.getGross()));
            at.addRule();
        }
        at.setTextAlignment(TextAlignment.CENTER);
        System.out.println(at.render());
    }

    public LinkedList<Movie> sort(LinkedList<Movie> movieList){
        movieList.sort(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        return movieList;
    }
}
