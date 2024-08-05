package com.movie_data_manipulation_program;

public class Write_All_Movie implements Write_Command{
    private Write_Movie writeMovie;
    //constructor
    public Write_All_Movie(Write_Movie writeMovie) {
        this.writeMovie = writeMovie;
    }
    // overwrite the method of Write_Command interface
    // invoke the writeAllMovie method of Write_Movie class
    @Override
    public void execute() {
        writeMovie.writeAllMovie();
    }
}
