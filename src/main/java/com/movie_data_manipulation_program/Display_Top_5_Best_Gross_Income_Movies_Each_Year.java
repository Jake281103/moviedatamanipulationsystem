package com.movie_data_manipulation_program;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class Display_Top_5_Best_Gross_Income_Movies_Each_Year{
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private String displayYear;
    private Singleton_Input_Validation sdv;
    public Display_Top_5_Best_Gross_Income_Movies_Each_Year(){}

    public Display_Top_5_Best_Gross_Income_Movies_Each_Year(HashMap<String, LinkedList<Movie>> movieHashMap,
                                                            Singleton_Input_Validation sdv) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("         TOP 5 BEST GROSS INCOME INCOME MOVIES EACH YEAR         ");
        System.out.println("-----------------------------------------------------------------");
        data_Display();
    }
    // report the top 5 best gross income movies each year
    private void data_Display() {
        Scanner sc = new Scanner(System.in);
        //requesting year to display the movie data
        System.out.print("Enter Year to report movie data: ");
        displayYear = sc.nextLine();
        while (!sdv.check_Year(displayYear.trim())) {
            System.out.print("Enter Year to report movie data: ");
            displayYear = sc.nextLine();
        }
        // extract data report data from movie hashmap
        for (String key : movieHashMap.keySet()){
            LinkedList<Movie> yearList = new LinkedList<>();
            for (Movie mv : movieHashMap.get(key)){
                if (displayYear.equals(mv.getYear())){
                    yearList.add(mv);
                }
            }
            //sorting the year list
            LinkedList<Movie> sortedList = sort(yearList);

            //display the report with asciiTable
            if (!yearList.isEmpty()) {
                System.out.println("Top Five Best Gross Income Movies Of " + key + " type at " + this.displayYear);
                AsciiTable at = new AsciiTable();
                at.addRule();
                at.addRow(Arrays.asList("MOVIE ID", "MOVIE ID", "YEAR", "CERTIFICATE", "RUNTIME", "RATING", "DIRECTOR", "STARS", "VOTES", "GROSS(in $)"));
                at.addRule();
                CWC_LongestLine cwc = new CWC_LongestLine();
                at.getRenderer().setCWC(cwc);
                for (int index = 0; index < 5 && index < sortedList.size(); index++) {
                    Movie mv = sortedList.get(index);
                    at.addRow(Arrays.asList(mv.getMovieId(), mv.getMovieName(), mv.getYear(), mv.getCertificate(), mv.getRuntime(), mv.getRating(), mv.getDirector(),
                            mv.getStar(), mv.getVotes(), mv.getGross()));
                    at.addRule();
                }
                at.setTextAlignment(TextAlignment.CENTER);
                System.out.println(at.render());
            }
            else {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("    Any " + key + " type movie is not found at " + displayYear);
                System.out.println("-----------------------------------------------------------------");
            }
        }

    }

    public LinkedList<Movie> sort(LinkedList<Movie> movieList){
        movieList.sort(Collections.reverseOrder(Comparator.comparing(Movie::getGross)));
        return movieList;
    }
}
