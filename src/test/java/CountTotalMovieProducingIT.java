import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CountTotalMovieProducingIT {
    static Read_Movie readMovie;
    static Display_Total_Movies_Producing_Each_Year_Each_Genre main;
    static HashMap<String,LinkedList<Movie>> movieHashMap;
    @BeforeAll
    public static void init()
    {
        readMovie = new Read_Movie("data/movie_data");
        main = new Display_Total_Movies_Producing_Each_Year_Each_Genre();
    }
    public static void prepareHashMap(){
        movieHashMap = readMovie.getMovieData();
    }
    @Test
    public void countTotalMovieProducingIntegrationTest(){
        prepareHashMap();
        int count = main.count(movieHashMap, "action","2019");
        assertEquals(1300, count);
    }
}
