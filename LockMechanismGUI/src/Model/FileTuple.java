package Model;

import java.io.BufferedReader;

public class FileTuple {
    private static int index = 0;
    private String filename;
    private BufferedReader fd;

    public FileTuple(String filename, BufferedReader fd)
    {
        index += 1;
        this.filename = filename;
        this.fd = fd;
    }

    public BufferedReader getFileDescriptor(){
        return fd;
    }

    public String getFilename(){
        return filename;
    }

    public int getIndex(){
        return index;
    }

    public void resetGenerator(){index = 0;}

    @Override
    public String toString(){
        return "(" + filename + " " + fd.toString() + ")";
    }
}
