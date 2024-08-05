package com.movie_data_manipulation_program;

public class Write_Command_Invoker {
    private Write_Command writeCommand;
    // write method and invoke execute method of Write_Command interface
    public void writeMovie(Write_Command writeCommand) {
        writeCommand.execute();
    }
}

