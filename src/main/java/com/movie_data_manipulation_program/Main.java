package com.movie_data_manipulation_program;

import java.util.*;

public class Main{
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private Scanner sc;
    private Singleton_Input_Validation sdv;
    private Write_Command_Invoker wci;

    public Main(String filepath){
        movieHashMap = new HashMap<>();
        sc = new Scanner(System.in);
        wci = new Write_Command_Invoker();
        sdv = Singleton_Input_Validation.get_Input_Validation();

        System.out.println("Loading data...");
        Movie_Data movieData = new Proxy_Read_Movie("data/movie_data");
        movieHashMap = movieData.getMovieData();
        System.out.println("Data are ready to use.");
    }

    // functional menu of the program
    private void menu() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                                  MENU                              ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("    1. Adding New Movie Data According to Genre");
        System.out.println("    2. Edit One Movie Data According to Genre");
        System.out.println("    3. Delete One Movie Data According to Genre");
        System.out.println("    4. Display Top 5 Rated Movie of Each Genre in Each Year");
        System.out.println("    5. Display Top 5 Best Gross Income movies in Each Year");
        System.out.println("    6. Display Total Movies producing in Each Year in Each Genre");
        System.out.println("    7. Exit");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Enter between 1 and 7 to choose the menu: ");
    }

    //checking the input menu option
    public boolean is_Menu_Range(String input) {
        List<String> menu_number = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        return menu_number.contains(input);
    }

    // display the functional menu of the program
    private void display_Menu() {
        menu();
        String input = sc.nextLine();
        while (!is_Menu_Range(input.trim())) {
            System.out.print("Enter only number between 1 and 8: ");
            input = sc.nextLine();
        }
        switch (input.trim()) {
            case "1" -> {
                new Adding_New_Movie_Data(movieHashMap, sdv, wci);
                display_Menu();
            }
            case "2" -> {
                new Updating_One_Movie_Data(movieHashMap, sdv, wci);
                display_Menu();
            }
            case "3" -> {
                new Delete_One_Movie_Data(movieHashMap, sdv, wci);
                display_Menu();
            }
            case "4" -> {
                new Display_Top_5_Rated_Movie_Each_Genre_Each_Year(movieHashMap, sdv);
                display_Menu();
            }
            case "5" -> {
                new Display_Top_5_Best_Gross_Income_Movies_Each_Year(movieHashMap, sdv);
                display_Menu();
            }
            case "6" -> {
                new Display_Total_Movies_Producing_Each_Year_Each_Genre(movieHashMap, sdv);
                display_Menu();
            }
            case "7" -> {
                System.out.print("Are you sure to exit? Y/N: ");
                input = sc.nextLine();
                while (!(input.trim().contentEquals("Y") || input.trim().contentEquals("N"))) {
                    System.out.print("Enter only Y or N: ");
                    input = sc.nextLine();
                }
                if (input.trim().contentEquals("Y")) {
                    System.out.println("Program is exited.");
                    System.exit(0);
                } else {
                    display_Menu();
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main("data/movie_data");
        m.display_Menu();
    }

}