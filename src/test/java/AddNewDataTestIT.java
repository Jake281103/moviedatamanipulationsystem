import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddNewDataTestIT {
    static Read_Movie main;
    static Adding_New_Movie_Data addMovie;

    @BeforeAll
    public static void init()
    {
        main = new Read_Movie("data/movie_data");
        addMovie = new Adding_New_Movie_Data();
    }
    @Test
    public void addNewMoviesIntegrationTest(){
        HashMap<String, LinkedList<Movie>>  oldmovieHashMap = main.getMovieData();
        HashMap<String,LinkedList<Movie>> allmovieHashMap = addMovie.readData("data/new_movies_2024.csv", oldmovieHashMap);
        assertEquals(8408, allmovieHashMap.get("animation").size());
    }
}
