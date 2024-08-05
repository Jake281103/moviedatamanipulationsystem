import com.movie_data_manipulation_program.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadDataIT {
    static Read_Movie main;
    @BeforeAll
    public static void init()
    {
        main = new Read_Movie("data/movie_data");
    }
    @Test
    public void readMovieDataIntegrationTest(){
        HashMap<String,LinkedList<Movie>> movieHashMap = main.getMovieData();
        assertEquals(16, movieHashMap.size());
    }
}
