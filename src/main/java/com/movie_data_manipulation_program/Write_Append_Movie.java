package com.movie_data_manipulation_program;

public class Write_Append_Movie implements Write_Command{
    private Write_Movie writeMovie;
    //constructor
    public Write_Append_Movie(Write_Movie writeMovie) {
        this.writeMovie = writeMovie;
    }
    // overwrite the method of Write_Command interface and
    // Invoke the writeAppendMovie method of Write_Movie class
    @Override
    public void execute() {
        writeMovie.writeAppendMovie();
    }
}
