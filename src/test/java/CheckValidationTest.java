import com.movie_data_manipulation_program.Movie;
import com.movie_data_manipulation_program.Singleton_Input_Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CheckValidationTest {
    static Singleton_Input_Validation main;
    static HashMap<String, LinkedList<Movie>> movieHashMap = new HashMap<>();
    @BeforeAll
    public static void init()
    {
        main = Singleton_Input_Validation.get_Input_Validation();
    }

    public static void prepareHashMap(){
        LinkedList<Movie> movieLinkedList = new LinkedList<>();
        movieLinkedList.add(new Movie("tt1825683","Black Panther","2018","PG-13","134 min","7.3","Ryan Coogler","Chadwick Boseman#Michael B. Jordan#Lupita Nyong'o#Danai Gurira","785813","700059566"));
        movieLinkedList.add(new Movie("tt0499549","Avatar","2009","PG-13","162 min","7.9","James Cameron","Sam Worthington#Zoe Saldana#Sigourney Weaver#Michelle Rodriguez","1322694","760507625"));
        movieLinkedList.add(new Movie("tt1392170","The Hunger Games","2012","PG-13","142 min","7.2","Gary Ross","Jennifer Lawrence#Josh Hutcherson#Liam Hemsworth#Stanley Tucci","927499","408010692"));
        movieLinkedList.add(new Movie("tt1160419","Dune","2021","PG-13","155 min","8","Denis Villeneuve","Timothée Chalamet#Rebecca Ferguson#Zendaya#Oscar Isaac","649342","108327830"));
        movieLinkedList.add(new Movie("tt0120737","The Lord of the Rings: The Fellowship of the Ring","2001","PG-13","178 min","8.8","Peter Jackson","Elijah Wood#Ian McKellen#Orlando Bloom#Sean Bean","1889727","315544750"));
        movieLinkedList.add(new Movie("tt4154796","Avengers: Endgame","2019","PG-13","181 min","8.4","Anthony Russo#Joe Russo","Robert Downey Jr.#Chris Evans#Mark Ruffalo#Chris Hemsworth","1148100","858373000"));
        movieLinkedList.add(new Movie("tt2911666","John Wick","2014","R","101 min","7.4","Chad Stahelski#David Leitch","Keanu Reeves#Michael Nyqvist#Alfie Allen#Willem Dafoe","644257","430378350"));
        movieLinkedList.add(new Movie("tt1856101","Blade Runner 2049","2017","R","164 min","8","Denis Villeneuve","Harrison Ford#Ryan Gosling#Ana de Armas#Dave Bautista","586274","920541599"));
        movieHashMap.put("action", movieLinkedList);
    }

    @Test
    public void checkFileTest(){
        boolean checkFilePath = main.check_File("data/new_movies_2024.csv");
        assertTrue(checkFilePath);
    }

    @Test
    public void checkIdTest(){
        boolean checkMovieId = main.check_Id("0399483");
        assertFalse(checkMovieId);
    }

    @Test
    public void checkGenreTest(){
        boolean checkMovieGenre = main.check_Genre("Action");
        assertFalse(checkMovieGenre);
    }

    @Test
    public void checkYearTest(){
        boolean checkMovieYear = main.check_Year("200");
        assertFalse(checkMovieYear);
    }

    @Test
    public void checkNameTest(){
        boolean checkMovieName = main.check_Name("The Beekeeper");
        assertTrue(checkMovieName);
    }

    @Test
    public void searchGenreIdTest(){
        int searchGenreId = main.searchGenreId(movieHashMap,"action","tt4998283");
        assertEquals(-1,searchGenreId);
    }
    @Test
    public void searchGenreYearTest(){
        boolean searchGenreYear = main.searchGenreYear(movieHashMap,"action","2024");
        assertFalse(searchGenreYear);
    }

}
