import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SortRatingIT {
    static Read_Movie readMovie;
    static Display_Top_5_Rated_Movie_Each_Genre_Each_Year main;
    static HashMap<String,LinkedList<Movie>> movieHashMap;
    @BeforeAll
    public static void init()
    {
        readMovie = new Read_Movie("data/movie_data");
        main = new Display_Top_5_Rated_Movie_Each_Genre_Each_Year();
    }
    public static void prepareHashMap(){
        movieHashMap = readMovie.getMovieData();
    }
    @Test
    public void sortRatingIntegrationTest(){
        prepareHashMap();
        LinkedList<Movie> actionList = movieHashMap.get("action");
        LinkedList<Movie> sortActionList = main.sort(actionList);
        String bestGrossIncomeMovie = sortActionList.getFirst().getMovieName();
        assertEquals("Low Heat", bestGrossIncomeMovie);
    }
}
