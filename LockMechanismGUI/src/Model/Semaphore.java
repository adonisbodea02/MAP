package Model;

import Model.ADTs.MyIDictionary;

public class Semaphore {

    private static int generator = 0;
    private MyIDictionary<Integer, SemaphorePair> dict;

    public Semaphore(MyIDictionary<Integer, SemaphorePair> dict){
        this.dict = dict;
    }

    public void resetGenerator(){generator = 0;}

    public int getID(){return generator++; }

    public MyIDictionary<Integer, SemaphorePair> getDict(){return dict;}

    @Override
    public String toString() {
        return dict.toString();
    }
}
