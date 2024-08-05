package com.movie_data_manipulation_program;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Adding_New_Movie_Data {
    private HashMap<String, LinkedList<Movie>> movieHashMap;
    private LinkedList<Movie> action, adventure, animation, biography, crime, family, fantasy, filmnoir,
            history, horror, mystery, romance, scifi, sports, thriller, war;
    private String year;
    private Singleton_Input_Validation sdv;
    private Write_Command_Invoker wci;
    public Adding_New_Movie_Data(){}
    public Adding_New_Movie_Data(HashMap<String, LinkedList<Movie>> movieHashMap,
                                 Singleton_Input_Validation sdv, Write_Command_Invoker wci) {
        this.movieHashMap = movieHashMap;
        this.sdv = sdv;
        this.wci = wci;
        System.out.println("--------------------------------------------------------");
        System.out.println("                   ADDING NEW MOVIE DATA                ");
        System.out.println("--------------------------------------------------------");
        requestInput();
    }
    //reading and write the new data file content and adding to the movieHashMap
    public HashMap<String, LinkedList<Movie>> readData(String filepath, HashMap<String, LinkedList<Movie>> movieHashMap) {
        action = new LinkedList<>();
        adventure = new LinkedList<>();
        animation = new LinkedList<>();
        biography = new LinkedList<>();
        crime = new LinkedList<>();
        family = new LinkedList<>();
        fantasy = new LinkedList<>();
        filmnoir = new LinkedList<>();
        history = new LinkedList<>();
        horror = new LinkedList<>();
        mystery = new LinkedList<>();
        romance = new LinkedList<>();
        scifi = new LinkedList<>();
        sports = new LinkedList<>();
        thriller = new LinkedList<>();
        war = new LinkedList<>();

        try {
            FileReader fr = new FileReader(filepath);
            CSVReader cr = new CSVReader(fr);
            String[] s = cr.readNext();
            while ((s = cr.readNext()) != null) {
                    if (s[4].contentEquals("action")) {
                        action.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    } else if (s[4].contentEquals("adventure")) {
                        adventure.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("animation")) {
                        animation.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("biography")) {
                        biography.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("crime")) {
                        crime.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("family")) {
                        family.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("fantasy")) {
                        fantasy.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("film-noir")) {
                        filmnoir.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("history")) {
                        history.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("horror")) {
                        horror.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("mystery")) {
                        mystery.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("romance")) {
                        romance.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("sci-fi")) {
                        scifi.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("sports")) {
                        sports.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("thriller")) {
                        thriller.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
                    else if (s[4].contentEquals("war")) {
                        war.add(new Movie(s[0],s[1],this.year,"-","-","-",(s[2].isEmpty())?"-":s[2],(s[3].isEmpty())?"-":s[3],"-","-"));
                    }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (String key : movieHashMap.keySet()){
            switch (key) {
                case "action" -> movieHashMap.get(key).addAll(action);
                case "adventure" -> movieHashMap.get(key).addAll(adventure);
                case "animation" -> movieHashMap.get(key).addAll(animation);
                case "biography" -> movieHashMap.get(key).addAll(biography);
                case "crime" -> movieHashMap.get(key).addAll(crime);
                case "family" -> movieHashMap.get(key).addAll(family);
                case "fantasy" -> movieHashMap.get(key).addAll(fantasy);
                case "film-noir" -> movieHashMap.get(key).addAll(filmnoir);
                case "history" -> movieHashMap.get(key).addAll(history);
                case "horror" -> movieHashMap.get(key).addAll(horror);
                case "mystery" -> movieHashMap.get(key).addAll(mystery);
                case "romance" -> movieHashMap.get(key).addAll(romance);
                case "sci-fi" -> movieHashMap.get(key).addAll(scifi);
                case "sports" -> movieHashMap.get(key).addAll(sports);
                case "thriller" -> movieHashMap.get(key).addAll(thriller);
                case "war" -> movieHashMap.get(key).addAll(war);
            }
        }
        return movieHashMap;
    }
    // request file path and year from user
    public void requestInput(){
        Scanner sc = new Scanner(System.in);

        //requesting new baby data file location from user
        System.out.print("Enter new name file path: ");
        String filepath = sc.nextLine();
        while(!sdv.check_File(filepath)) {
            System.out.print("Enter new name file path: ");
            filepath = sc.nextLine();
        }
        //requesting year for new baby data file from user
        System.out.print("Enter Year: ");
        year = sc.nextLine();
        while(!sdv.check_Year(year)) {
            System.out.print("Enter Year: ");
            year = sc.nextLine();
        }
        HashMap<String, LinkedList<Movie>> allmovieHashMap = readData(filepath, movieHashMap);
        write(allmovieHashMap);
    }

    public void write(HashMap<String, LinkedList<Movie>> allmovieHashMap){
        wci.writeMovie(new Write_All_Movie(new Write_Movie(allmovieHashMap, "data/movie_data")));
        System.out.println("New data is successfully saved.");
        System.out.println("--------------------------------------------------------");
    }
}
