package Model;

import Model.ADTs.MyIDictionary;

public class Heap {
    private static int generator = 1;
    private MyIDictionary<Integer, Integer> dict;

    public Heap(MyIDictionary<Integer, Integer> dict){
        this.dict = dict;
    }

    public void resetGenerator(){generator = 1;}

    public int getID(){return generator++; }

    public MyIDictionary<Integer, Integer> getDict(){return dict;}

    @Override
    public String toString() {
        return dict.toString();
    }

}
