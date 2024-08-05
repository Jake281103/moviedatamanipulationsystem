import com.movie_data_manipulation_program.Delete_One_Movie_Data;
import com.movie_data_manipulation_program.Display_Total_Movies_Producing_Each_Year_Each_Genre;
import com.movie_data_manipulation_program.Movie;
import com.movie_data_manipulation_program.Updating_One_Movie_Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CountTest {
    static Display_Total_Movies_Producing_Each_Year_Each_Genre main;
    static HashMap<String, LinkedList<Movie>> movieHashMap = new HashMap<>();
    @BeforeAll
    public static void init()
    {
        main = new Display_Total_Movies_Producing_Each_Year_Each_Genre();
    }

    public static void prepareHashMap(){
        LinkedList<Movie> movieLinkedList = new LinkedList<>();
        movieLinkedList.add(new Movie("tt1630029","Avatar: The Way of Water","2022",
                "PG-13","192 min","7.8","James Cameron",
                "Sam Worthington#Zoe Saldana#Sigourney Weaver#Stephen Lang","295119","-"));
        movieHashMap.put("action", movieLinkedList);
    }
    @Test
    public void countMovieTest(){
        prepareHashMap();
        int count = main.count(movieHashMap,"action","2022");
        assertEquals(1, count);
    }
}
