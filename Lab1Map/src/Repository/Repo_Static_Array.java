package Repository;

import Exceptions.My_Exception;
import Model.Aliment;

public class Repo_Static_Array implements Repository{
    private Aliment[] aliments;
    private int capacity;
    private int size;


    public Repo_Static_Array(int capacity)
    {
        this.capacity = capacity;
        aliments = new Aliment[100];
        this.size = 0;
    }

    @Override
    public void add(Aliment a) {
        if (this.size < this.capacity)
            aliments[size++] = a;
        else
            throw new My_Exception("The repository is full!");
    }

    @Override
    public void delete(int pos) {
        if (pos < this.size && this.size > 0) {
            if (this.size - pos >= 0) System.arraycopy(aliments, pos + 1, aliments, pos, this.size - pos);
            size--;
        }
        else
            throw new My_Exception("Repository is empty, the position is invalid or the position has no aliment!");

    }

    @Override
    public String filter(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < this.size; i++) {
            if (aliments[i].get_price() > 20)
                s.append(aliments[i]);
        }
        return s.toString();
    }
}