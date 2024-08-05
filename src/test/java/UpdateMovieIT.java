import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UpdateMovieIT {
    static Read_Movie readMovie;
    static Updating_One_Movie_Data main;
    static HashMap<String,LinkedList<Movie>> movieHashMap;
    @BeforeAll
    public static void init()
    {
        readMovie = new Read_Movie("data/movie_data");
        main = new Updating_One_Movie_Data();
    }
    public static void prepareHashMap(){
        movieHashMap = readMovie.getMovieData();
    }
    @Test
    public void updateMovieIntegrationTest(){
        prepareHashMap();
        main.update(movieHashMap,"action",0,"The Beekeeper");
        String updateMovieName = movieHashMap.get("action").getFirst().getMovieName();
        assertEquals("The Beekeeper", updateMovieName);
    }
}
