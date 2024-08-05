import com.movie_data_manipulation_program.Main;
import com.movie_data_manipulation_program.Movie;
import com.movie_data_manipulation_program.Singleton_Input_Validation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CheckMenuRange {
    static Main main;
    @BeforeAll
    public static void init()
    {
        main = new Main("data/movie_data");
    }
    @Test
    public void checkMenuRangeTest(){
        boolean checkMenuRange = main.is_Menu_Range("8");
        assertFalse(checkMenuRange);
    }
}
