package Model;

import java.util.LinkedList;
import java.util.List;

public class SemaphorePair {
    private int counter;
    private List<Integer> programs;

    public SemaphorePair(int counter){
        this.counter = counter;
        this.programs = new LinkedList<>();
    }

    public int getCounter(){return counter;}
    public List<Integer> getPrograms(){return programs;}

    @Override
    public String toString() {
        return "(" + String.valueOf(counter) + "->" + programs.toString() + ")";
    }
}
