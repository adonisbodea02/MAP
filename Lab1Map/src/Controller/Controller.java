package Controller;

import Model.Aliment;
import Repository.Repository;

public class Controller {

    private Repository r;

    public Controller(Repository r){
        this.r = r;
    }

    public void add(Aliment a){
        this.r.add(a);
    }

    public void delete(int pos){
        this.r.delete(pos);
    }

    public String filter(){
        return this.r.filter();
    }
}
