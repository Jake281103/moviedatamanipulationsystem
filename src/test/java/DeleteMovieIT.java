import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DeleteMovieIT {
    static Read_Movie readMovie;
    static Delete_One_Movie_Data main;
    static HashMap<String,LinkedList<Movie>> movieHashMap;
    @BeforeAll
    public static void init()
    {
        readMovie = new Read_Movie("data/movie_data");
        main = new Delete_One_Movie_Data();
    }
    public static void prepareHashMap(){
        movieHashMap = readMovie.getMovieData();
    }
    @Test
    public void deleteMovieIntegrationTest(){
        prepareHashMap();
        System.out.println("Size of action linked-list Before deleting: "+movieHashMap.get("action").size());
        main.remove(movieHashMap,"action",0);
        System.out.println("Size of action linked-list After deleting: "+movieHashMap.get("action").size());
    }
}
