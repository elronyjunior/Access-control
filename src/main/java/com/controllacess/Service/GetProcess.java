package com.controllacess.Service;

import java.io.IOException;

public class GetProcess {

    private GetProcess(){

    }

    public static Process get(String path) throws IOException{
        ProcessBuilder builder = new ProcessBuilder(path);
        return builder.start();
    }
}
