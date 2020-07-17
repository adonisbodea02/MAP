package Model;

public class HeapIDGenerator {

    private static int id = 0;

    public HeapIDGenerator(){
        id++;
    }

    public int getID(){return id;}

    public void resetGenerator(){id = 0;}
}
